/*
Copyright 2009 Ramnivas Laddad

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

//Listing 7.9 Collecting the return value and thrown exception
package ajia.monitoring;

import java.sql.Connection;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//import ....

@Aspect
public class ConnectionMonitor {
	@Pointcut("call(* java.sql.Connection.*(..))" + " && target(connection)")
	public void connectionOperation(Connection connection) {
	}

	@AfterReturning(value = "connectionOperation(connection)", returning = "ret")
	public void monitorSuccessfulUse(Connection connection, Object ret) {
		System.out.println("Just used " + connection
				+ " successfully which returned " + ret);
	}

	@AfterThrowing(value = "connectionOperation(connection)", throwing = "ex")
	public void monitorFailedUse(Connection connection, Exception ex) {
		System.out.println("Just used " + connection
				+ " but met with a failure of kind " + ex);
	}
}