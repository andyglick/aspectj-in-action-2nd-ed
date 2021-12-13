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

package ajia.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class SysoutLoginService implements LoginService {
	public Authentication getAuthenticationToken() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Username: ");
			String userName = in.readLine().trim();
			System.out.print("Password: ");
			String password = in.readLine().trim();
			return new UsernamePasswordAuthenticationToken(userName, password);
		} catch (IOException ex) {
			return null;
		}
	}
}
