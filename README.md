pingdom-java
============

A Java wrapper around the [Pingdom RESTful API][1] and a simple DSL for easy
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
    manager.setAuthentication("your_email@email.com", "your_password");
    manager.setAppKey("your_api_key");
    
    System.out.println("\nLast two alerts:");
    Actions actionsLimited = manager.actionsService().get().limit(2).fire();
    for (Actions.Alert alert : actionsLimited.getAlerts()) {
    	System.out.println(alert.getMessageFull());
    }
    
    System.out.println("\nCheck list:");
    Integer firstCheck = null;
    List<Check> checks = manager.checkService().list().fire();
    for (Check check : checks) {
    	if (firstCheck == null) {
    		firstCheck = check.getId();
    	}
    	System.out.println(check.getName() + " - " + check.getHostName());
    }
    
    System.out.println("\nCheck " + firstCheck + ":");
    Check check = manager.checkService().get(firstCheck).fire();
    System.out.println("- Name: " + check.getName());
    System.out.println("- Host: " + check.getHostName());
    System.out.println("- Type: " + check.getType().getNative());
    System.out.println("- Send to Email: " + check.getSendToEmail());
    System.out.println("- Send to SMS: " + check.getSendToSms());
    System.out.println("- Send to Twitter: " + check.getSendToTwitter());
    System.out.println("- Send to iPhone: " + check.getSendToIPhone());
    
    System.out.println("\nPingdom Server Time:");
    System.out.println(manager.serverTimeService().get().fire().getServiceTime());
    
    System.out.println("\nSettings:");
    Settings settings = manager.settingsService().get().fire();
    System.out.println("- Name: " + settings.getFirstName() + " " + settings.getLastName());
    System.out.println("- Email: " + settings.getEmail());
    System.out.println("- Registered: " + settings.getAccountCreated());

Real examples and tests to come soon.


Documentation
-------------

 * Javadocs are available at [jakewharton.github.com/pingdom-java/][2].
 * Repository is hosted on [github.com/JakeWharton/pingdom-java/][3].
 * Native API is documented on [pingdom.com/services/api-documentation-rest/][4].



Developed By
============

* Jake Wharton - <jakewharton@gmail.com>


Contributors
------------

The overall package and class layout as well as approximately 50% of the code
in the `Pingdom*` classes are based on [nabeelmukhtar's github-java-sdk
library][5].



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




 [1]: http://www.pingdom.com/services/api/
 [2]: http://jakewharton.github.com/pingdom-java/
 [3]: https://github.com/JakeWharton/pingdom-java/
 [4]: http://www.pingdom.com/services/api-documentation-rest/
 [5]: https://github.com/nabeelmukhtar/github-java-sdk
