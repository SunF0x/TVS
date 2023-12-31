package com.labs;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

import com.labs.client.Client;
import org.apache.juddi.api_v3.AccessPointType;
import org.apache.juddi.v3.client.UDDIConstants;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.transport.Transport;
//import org.example.client.Client;
import org.uddi.api_v3.*;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;

/**
 * A Simple UDDI Browser that dumps basic information to console
 *
 * @author <a href="mailto:alexoree@apache.org">Alex O'Ree</a>
 */
public class App {
    private static UDDISecurityPortType security = null;
    private static UDDIInquiryPortType inquiry = null;
    private static UDDIPublicationPortType publish = null;


    public static void main(String args[]) throws Exception {
        App app = new App();
        String token = GetAuthKey("SunF0x", "1809");

        Scanner in = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);

        while (true) {
            System.out.print(" 1 - Register\n 2 - Find\n 3 - Exit\n");
            int option = in.nextInt();
            System.out.printf("Your option: %d \n", option);
            switch (option) {
                case 1:
                    System.out.print("Register\n");
                    System.out.println("Enter jUDDI Business Name (default: SerialService)?");
                    String businessName = scanString.nextLine();
                    if (businessName.trim().isEmpty()) {
                        businessName = "SerialService";
                    }
                    System.out.println("Enter jUDDI Service Name (default: SerialService)?");
                    String registeredServiceName = scanString.nextLine();
                    if (registeredServiceName.trim().isEmpty()) {
                        registeredServiceName = "SerialService";
                    }

                    System.out.println("Enter jUDDI Service Access Point (default: http://localhost:8081/SerialService?wsdl)?");
                    String registeredServiceURL = scanString.nextLine();
                    if (registeredServiceURL.trim().isEmpty()) {
                        registeredServiceURL = "http://localhost:8081/SerialService?wsdl";
                    }

                    BusinessEntity myBusEntity = new BusinessEntity();
                    Name myBusName = new Name();
                    myBusName.setValue(businessName);
                    myBusEntity.getName().add(myBusName);

                    SaveBusiness sb = new SaveBusiness();
                    sb.getBusinessEntity().add(myBusEntity);
                    sb.setAuthInfo(token);

                    try {
                        BusinessDetail bd = publish.saveBusiness(sb);
                        String myBusKey = bd.getBusinessEntity().get(0).getBusinessKey();

                        BusinessService myService = new BusinessService();
                        myService.setBusinessKey(myBusKey);
                        Name myServName = new Name();
                        myServName.setValue(registeredServiceName);
                        myService.getName().add(myServName);

                        BindingTemplate myBindingTemplate = new BindingTemplate();
                        AccessPoint accessPoint = new AccessPoint();
                        accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
                        accessPoint.setValue(registeredServiceURL);
                        myBindingTemplate.setAccessPoint(accessPoint);
                        BindingTemplates myBindingTemplates = new BindingTemplates();
                        myBindingTemplate = UDDIClient.addSOAPtModels(myBindingTemplate);
                        myBindingTemplates.getBindingTemplate().add(myBindingTemplate);

                        myService.setBindingTemplates(myBindingTemplates);

                        SaveService ss = new SaveService();
                        ss.getBusinessService().add(myService);
                        ss.setAuthInfo(token);
                        ServiceDetail sd = publish.saveService(ss);
                        String myServKey = sd.getBusinessService().get(0).getServiceKey();
                        System.out.println("Service key:  " + myServKey);

                        System.out.println("Registered!");
                    } catch (DispositionReportFaultMessage e) {
                        throw new RuntimeException(e);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.print("Find\n");
                    System.out.println("Enter jUDDI Service Name for search (default: SerialService)?");
                    String searchServiceName = scanString.nextLine(); //SerialService

                    if (searchServiceName.trim().isEmpty()) {
                        searchServiceName = "SerialService";
                    }

                    String accessPoint = null;
                    BusinessInfos BI = app.GetBusinessList(inquiry, token).getBusinessInfos();
                    for (int i = 0; i < BI.getBusinessInfo().size(); i++) {
                        GetServiceDetail gsd = new GetServiceDetail();
                        try {
                            for (int k = 0; k < BI.getBusinessInfo().get(i).getServiceInfos().getServiceInfo().size(); k++) {
                                gsd.getServiceKey().add(BI.getBusinessInfo().get(i).getServiceInfos().getServiceInfo().get(k).getServiceKey());
                            }
                            gsd.setAuthInfo(token);
                            ServiceDetail serviceDetail = inquiry.getServiceDetail(gsd);
                            for (int k = 0; k < serviceDetail.getBusinessService().size(); k++) {
                                BusinessService get = serviceDetail.getBusinessService().get(k);

                                if (ListToString(get.getName()).equals(searchServiceName)) {
                                    System.out.println("Find!!!");
                                    System.out.println("Access Point: " + BI.getBusinessInfo().get(i).getBusinessKey());
                                    accessPoint = getServiceAccessPoint(get.getBindingTemplates());
                                    System.out.println(accessPoint);
                                }
                                if (accessPoint != null) {
                                    break;
                                }
                            }
                        } catch (NullPointerException ex) {
                            System.out.println("Error: " + ex);
                            accessPoint = null;
                            break;
                        }
                    }
                    Client serviceClient = new Client();
                    serviceClient.serviceRequest(accessPoint);
                    break;
            }
            if (option == 3) break;

        }

    }
    public App() {
        try {
            UDDIClient client = new UDDIClient("META-INF/service_search.xml");
            Transport transport = client.getTransport("default");

            security = transport.getUDDISecurityService();
            inquiry = transport.getUDDIInquiryService();
            publish = transport.getUDDIPublishService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String GetAuthKey(String username, String password) {
        try {

            GetAuthToken getAuthTokenRoot = new GetAuthToken();
            getAuthTokenRoot.setUserID(username);
            getAuthTokenRoot.setCred(password);

            AuthToken rootAuthToken = security.getAuthToken(getAuthTokenRoot);
            return rootAuthToken.getAuthInfo();
        } catch (Exception ex) {
            System.out.println("Could not authenticate with the provided credentials " + ex.getMessage());
        }
        return null;
    }

    private BusinessList GetBusinessList(
            UDDIInquiryPortType inquiry,
            String token)
            throws Exception {
        FindBusiness fb = new FindBusiness();
        fb.setAuthInfo(token);
        org.uddi.api_v3.FindQualifiers fq = new org.uddi.api_v3.FindQualifiers();
        fq.getFindQualifier().add(UDDIConstants.APPROXIMATE_MATCH);
        fb.setFindQualifiers(fq);
        Name searchName = new Name();
        searchName.setValue(UDDIConstants.WILDCARD);
        fb.getName().add(searchName);

        return inquiry.findBusiness(fb);
    }

    private static String getServiceAccessPoint(BindingTemplates bindingTemplates) {
        if (bindingTemplates == null) {
            return null;
        }
        String serviceAccessPoint = null;
        for (int i = 0; i < bindingTemplates.getBindingTemplate().size(); i++) {
            if (bindingTemplates.getBindingTemplate().get(i).getAccessPoint() != null) {
                if (bindingTemplates.getBindingTemplate().get(i).getAccessPoint().getUseType() != null) {
                    if (bindingTemplates.getBindingTemplate().get(i).getAccessPoint().getUseType().equalsIgnoreCase(AccessPointType.WSDL_DEPLOYMENT.toString())) {
                        serviceAccessPoint = bindingTemplates.getBindingTemplate().get(i).getAccessPoint().getValue();
                    }
                }
            }
        }
        return serviceAccessPoint;
    }

    private static String ListToString(List<Name> name) {
        StringBuilder sb = new StringBuilder();
        for (Name value : name) {
            sb.append(value.getValue());
        }
        return sb.toString();
    }

}