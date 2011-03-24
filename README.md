pingdom-java
============

A Java wrapper around the Pingdom RESTful API and a simple DSL for easy
interaction.

**WARNING**: This library is under rapid development and APIs are subject to
change at any time without warning.



Usage
=====

Quick example:

    ServiceManager manager = new ServiceManager();
    manager.setAuthentication("your_pingdom@email.com", "your_password");
    manager.setAppKey("your_api_key");
    
    System.out.println();
    Actions actions = manager.actionsService().get().fire();
    for (Actions.Alert alert : actions.getAlerts()) {
    	System.out.println(alert.getMessageFull());
    	System.out.println();
    }
    
    System.out.println();
    Actions actionsLimited = manager.actionsService().get().limit(2).fire();
    for (Actions.Alert alert : actionsLimited.getAlerts()) {
    	System.out.println(alert.getMessageFull());
    	System.out.println();
    }
    
    System.out.println();
    List<Check> checks = manager.checkService().list().fire();
    for (Check check : checks) {
    	System.out.println(check.getId());
    	System.out.println(check.getName());
    	System.out.println(check.getHostName());
    	System.out.println();
    }
    System.out.println();
    Check check = manager.checkService().get(197967).fire();
    System.out.println(check.getName());
    System.out.println(check.getHostName());
    System.out.println(check.getSendToEmail());
    System.out.println(check.getSendToSms());
    System.out.println(check.getSendToTwitter());
    System.out.println(check.getSendToIPhone());
    System.out.println();

Real examples and tests to come soon.



Developed By
============

* Jake Wharton - <jakewharton@gmail.com>



License
=======

    Copyright 2011 Jake Wharton

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
