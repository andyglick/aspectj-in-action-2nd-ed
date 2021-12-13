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

//Listing 11.18 Aspect to detect dirty session state (Spring weaving)
package ajia.jpa.enforcement;

//import ...
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;

@Aspect
public class JpaJdbcPolicyEnforcement {
    // ... unchanged since listing 11.16
    private static Logger logger = Logger
            .getLogger(JpaJdbcPolicyEnforcement.class);
    @PersistenceContext
    private EntityManager em;

    @Pointcut("ajia.spring.SpringPointcuts.jdbcTemplateExecution()")
    public void jdbcExecution() {
    }

    @Before("jdbcExecution()")
    public void checkFlushedSession() {
        // ... unchanged since listing 11.16
        Session currentSession = (Session) em.getDelegate();
        if (currentSession != null && currentSession.isOpen()
                && currentSession.isDirty()) {
            logger
                    .error("Dirty session detected before "
                            + "a JDBC call, use EntityManager.flush()",
                            new Throwable());
        }
    }
}