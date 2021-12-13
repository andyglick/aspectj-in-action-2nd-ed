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

//Listing 7.15 Using the declared parent in advice
package ajia.tracking;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareMixin;

//import ...

@Aspect
public class AccountTracking {
	@DeclareMixin("ajia.banking.domain.*")
	public Identifiable identifiableMixin() {
		return new IdentifiableDefaultImpl();
	}

	@AfterReturning("execution(* ajia.banking.domain.*.*(..))"
			+ " && this(identifiable)")
	public void track(Identifiable identifiable) {
		System.out.println("Object with id " + identifiable.getId());
	}
}