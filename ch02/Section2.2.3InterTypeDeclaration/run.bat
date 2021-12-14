@rem Copyright 2009 Ramnivas Laddad
@rem 
@rem Licensed under the Apache License, Version 2.0 (the "License"); 
@rem you may not use this file except in compliance with the License. 
@rem You may obtain a copy of the License at 
@rem     http://www.apache.org/licenses/LICENSE-2.0 
@rem 
@rem Unless required by applicable law or agreed to in writing, software 
@rem distributed under the License is distributed on an "AS IS" BASIS, 
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
@rem See the License for the specific language governing permissions and 
@rem limitations under the License. 

call ..\..\..\setHomes.bat
call ..\..\..\setEnvironment.bat
@echo off
cd src\main\java
@echo on
call ajc -source 5 ajia\messaging\MessageCommunicator.java ajia\main\Main.java ajia\security\SecurityAspect.aj ajia\security\*.java ajia\profile\ProfilingAspect.aj ajia\track\TrackingAspect.aj
@echo on
call java ajia.main.Main
@echo off
cd ..\..\..\
@echo on 