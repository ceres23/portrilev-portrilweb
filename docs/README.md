# Configurations
All configuration MUST be set in the `buildfiles/<env>.properties` file used for compilation
- nome.ambiente = the currently executinf environment
- datasource.jndi-url = the datasource JNDI name
- messageSources.cacheSeconds = Spring messages timeout. May be left at -1 to prevent staleness
- mailSmtp = SMPT address for the mailing subsystem
- provider = mailing provider
- url.logout = SSO logout URL
- @dbconnection-url@ = DB connection URL
- @dbdriver@ = DB driver
- @dbdriver-class@ = DB driver class
- @dbuser-name@ = DB user name
- @dbpassword@ = DB password
- log.level = The default logging level
- log.file = The logging file
- jspath = The path for the JS files
- 
