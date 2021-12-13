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

//Listing 13.14: AsynchronousExecutionAspect.java
package ajia.concurrent;

//import ...
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract aspect AsynchronousExecutionAspect {
    private Executor executor = Executors.newCachedThreadPool();

    public abstract pointcut asyncOperation();

    void around() : asyncOperation() {
        Runnable worker = new Runnable() {
            public void run() {
                proceed();
            }
        };
        executor.execute(worker);
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }
}