package de.flameboard.manage.actuator;

import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

/**
 * object that can be mapped out of json file and contains some lists of
 * urls to services which can be tracked
 * TODO:
 * maybe its better to change to a serverholder object and server objects as childs which can hold more
 * informations where to find the actuator endpoint
 * that would make it possible to add more implementations for more endpoints of other applications
 *
 * @author svenklemmer
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Server {

  @JsonProperty("ui")
  private List<String> uiServices;

  @JsonProperty("backend")
  private List<String> backendServices;

  @JsonProperty("services")
  private List<String> otherServices;

  public Server() {
    uiServices = Lists.newArrayList();
    backendServices = Lists.newArrayList();
    otherServices = Lists.newArrayList();
  }

  @JsonIgnore
  public void addUiService(String ui) throws MalformedURLException {
//    CustomAssert.doesContain(ui, "http://");*/
    uiServices.add(ui);
  }
  @JsonIgnore
  public void addBackendService(String ui) throws MalformedURLException {
//    CustomAssert.doesContain(ui, "http://");
    backendServices.add(ui);
  }
  @JsonIgnore
  public void addOtherService(String ui) throws MalformedURLException {
//    CustomAssert.doesContain(ui, "http://");
    otherServices.add(ui);
  }

  @JsonIgnore
  public void removeUiService(String s) {
    uiServices.remove(s);
  }

  @JsonIgnore
  public void removeBackendService(String s) {
    backendServices.remove(s);
  }

  @JsonIgnore
  public void removeOtherService(String s) {
    otherServices.remove(s);
  }

  public List<String> getUiServices() {
    return uiServices;
  }

  public void setUiServices(List<String> aUiServices) {
    uiServices = aUiServices;
  }

  public List<String> getBackendServices() {
    return backendServices;
  }

  public void setBackendServices(List<String> aBackendServices) {
    backendServices = aBackendServices;
  }

  public List<String> getOtherServices() {
    return otherServices;
  }

  public void setOtherServices(List<String> aOtherServices) {
    otherServices = aOtherServices;
  }
}
