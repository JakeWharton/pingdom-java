pingdom-java
============

A Java wrapper around the Pingdom RESTful API and a simple DSL for easy
interaction.

Remote services are grouped into local service objects which can be centrally
managed by a `ServiceManager` instance. The manager will act as a factory for
all of the services and will automatically initialize them with your
credentials and API key.

Each service contains methods which correspond to a remote method. Each of
these methods instantiates a class that will allow for you to build the
parameters using the Java builder pattern.

Required remote method parameters will be arguments to the service method and
all of the methods in the returned builder are optional.

When fully assembled, you can trigger the remote execution by calling the
`fire()` method. This will return a native object which represents the result
of the execution. All returned objects are immutable and should be handled
as such.


**Note**: While the Pingdom RESTful API remains in public beta all of the
released versions of this library will be in the 0.9.x series. Only when the
API is declared fully stable will version 1.0 be released. During this grace
period the wrapper API should remain relatively stable. However, this is not a
guarantee and all implementing programs should consult the change log file to
learn about any changes with new versions.



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


Contributors
------------

The overall package and class layout as well as approximately 50% of the code
in the `Pingdom*` classes are based on nabeelmukhtar's github-java-sdk library.



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
