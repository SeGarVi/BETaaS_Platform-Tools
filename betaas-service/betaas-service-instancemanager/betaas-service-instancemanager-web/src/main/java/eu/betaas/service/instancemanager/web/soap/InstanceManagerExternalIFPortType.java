/*
Copyright 2014-2015 Intecs Spa

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

package eu.betaas.service.instancemanager.web.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2014-04-04T18:30:30.843+02:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://api.instancemanager.service.betaas.eu/", name = "InstanceManagerExternalIFPortType")
@XmlSeeAlso({ObjectFactory.class})
public interface InstanceManagerExternalIFPortType {

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "getAdminAddress", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetAdminAddress")
    @WebMethod
    @ResponseWrapper(localName = "getAdminAddressResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetAdminAddressResponse")
    public java.lang.String getAdminAddress();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "getGWStarID", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetGWStarID")
    @WebMethod
    @ResponseWrapper(localName = "getGWStarIDResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetGWStarIDResponse")
    public java.lang.String getGWStarID();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "requestJoin", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.RequestJoin")
    @WebMethod
    @ResponseWrapper(localName = "requestJoinResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.RequestJoinResponse")
    public boolean requestJoin(
        @WebParam(name = "arg0", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "isGWStar", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.IsGWStar")
    @WebMethod
    @ResponseWrapper(localName = "isGWStarResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.IsGWStarResponse")
    public boolean isGWStar();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "getDescription", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetDescription")
    @WebMethod
    @ResponseWrapper(localName = "getDescriptionResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetDescriptionResponse")
    public java.lang.String getDescription();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "getGWID", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetGWID")
    @WebMethod
    @ResponseWrapper(localName = "getGWIDResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetGWIDResponse")
    public java.lang.String getGWID();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "requestDisjoin", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.RequestDisjoin")
    @WebMethod
    @ResponseWrapper(localName = "requestDisjoinResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.RequestDisjoinResponse")
    public boolean requestDisjoin();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "getInstanceInfo", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetInstanceInfo")
    @WebMethod
    @ResponseWrapper(localName = "getInstanceInfoResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetInstanceInfoResponse")
    public java.lang.String getInstanceInfo();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "joinInstance", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.JoinInstance")
    @WebMethod
    @ResponseWrapper(localName = "joinInstanceResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.JoinInstanceResponse")
    public boolean joinInstance(
        @WebParam(name = "arg0", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "disjoinInstance", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.DisjoinInstance")
    @WebMethod
    @ResponseWrapper(localName = "disjoinInstanceResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.DisjoinInstanceResponse")
    public boolean disjoinInstance(
        @WebParam(name = "arg0", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "getInstanceID", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetInstanceID")
    @WebMethod
    @ResponseWrapper(localName = "getInstanceIDResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetInstanceIDResponse")
    public java.lang.String getInstanceID();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "getJoinedGWs", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetJoinedGWs")
    @WebMethod
    @ResponseWrapper(localName = "getJoinedGWsResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.GetJoinedGWsResponse")
    public eu.betaas.service.instancemanager.web.soap.ArrayOfString getJoinedGWs();

    @WebResult(name = "return", targetNamespace = "http://api.instancemanager.service.betaas.eu/")
    @RequestWrapper(localName = "isBackupStar", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.IsBackupStar")
    @WebMethod
    @ResponseWrapper(localName = "isBackupStarResponse", targetNamespace = "http://api.instancemanager.service.betaas.eu/", className = "eu.betaas.service.instancemanager.web.soap.IsBackupStarResponse")
    public boolean isBackupStar();
}