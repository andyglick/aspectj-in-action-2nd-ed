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

//Listing 7.2 System monitoring: using a named pointcut
package ajia.monitoring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SystemHealthMonitor {
	HeartBeatListener heartBeatListener = new HeartBeatListener();

	@Pointcut("execution(* *.*(..)) && !within(ajia.monitoring.*)")
	public void aliveOperation() {
	}

	@Before("aliveOperation()")
	public void beatHeart() {
		heartBeatListener.beat();
	}
}