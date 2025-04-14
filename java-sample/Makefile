run:install-no-test
	java -jar --enable-preview target/java-project-1.0-SNAPSHOT.jar

just-run:
	java -jar --enable-preview target/java-project-1.0-SNAPSHOT.jar

package:
	mvn clean package -Dusertimezone=UTC

install:
	mvn clean install -Dusertimezone=UTC -Duser.country.format=US -Duser.language.format=en

install-no-test:
	mvn clean install -DskipTests=true -Dsonar.skip=true -Dusertimezone=UTC

test:
	mvn clean test -Dusertimezone=UTC -Duser.country.format=US -Duser.language.format=en

