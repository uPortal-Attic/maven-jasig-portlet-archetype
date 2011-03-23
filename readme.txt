OVERVIEW

jsr168-archetype is a custom maven archetype that is used to generate
a uPortal specific Spring Portlet MVC shell.  This archectype can be
installed to a local M2_REPO, and then it may be used to generate a uPortal
JSR 168 portlet starter shell.  This maven archetype has a web.xml that is
specific to uPortal.  If you need something more generic, consider using the
portlet-gen archetype.

PREREQS

Use of this archetype assumes that you have JDK 1.5.0_16 or higher
installed.  You must also have Apache Maven 2+ installed.  On a *nix
system you can issue the following command to verify your installs:

[cpfrank@EA-0025 ~]$ mvn -version
Maven version: 2.0.9
Java version: 1.5.0_16
OS name: "linux" version: "2.6.26.5-45.fc9.i686" arch: "i386" Family: "unix"

Make sure your $PATH includes M2_HOME/bin and JAVA_HOME/bin (see install docs
for Apache Maven 2, and Sun's site for further information on installing and
configuring Maven and Java).


USAGE

In order to use the jsr168-archetype archetype you need to do the following:

1.  Download or checkout the jsr168-archetype src code from revision control.

2.  Change directories into the root of jsr168-archetype (you should
    see a pom.xml file in the top directory).

3.  Run the following command:

    [cpfrank@EA-0025] mvn install

    This command will install the archetype into the local M2_REPO.
    If it is run for the first time, it may take some time to download
    the associated artifacts needed by the archetype from a public maven
    repository.

    You should see output similar to:

    INFO] Installing
    /home/cpfrank/projects/java/jsr168-archetype/target/jsr168-archetype-1.0-SNAPSHOT.jar
    to /home/cpfrank/.m2/repository/ca/uvic/portal/jsr168-archetype/1.0-SNAPSHOT/jsr168-archetype-1.0-SNAPSHOT.jar


4.  Next you need to establish the archetype as a local catalog entry
    for lookup during the portlet generation process.  The maven plugin and
    target 'archetype:update-local-catalog' registers the archetype with
    your local archetype repository:

    [cpfrank@EA-0025] cd /home/cpfrank/projects/java/jsr168-archetype
    [cpfrank@EA-0025 jsr168-archetype]$ mvn archetype:update-local-catalog

5.  Now we can look up that catalog entry when we create a new portlet, with
    the following command (probably issued from your eclipse workspace):

    [cpfrank@EA-0025] cd /home/cpfrank/workspace
    [cpfrank@EA-0025 workspace]$ mvn archetype:generate -DarchetypeCatalog=local

    In the standard out, we should see output like this:

    Choose archetype:
    1: local -> jsr168-archetype (Archetype - jsr168-archetype)

    You will receive a prompt like the following:

    Choose archetype:
    1: local -> jsr168-archetype (Archetype - jsr168-archetype)
    Choose a number:  (1): 1
    Define value for groupId: : ca.uvic.portal
    Define value for artifactId: : MyNewPortletName
    Define value for version:  1.0-SNAPSHOT: :
    Define value for package: : ca.uvic.portal.MyNewPortletName

    You will need to provide your groupId, artifactId, version, and package
    parameters specific to your portlet.  Often groupId and package will be
    the same (package is a Java package prefix).  artifactId is a maven
    property that is analogous to project name.

SUMMARY

In summary, you can use this jsr168-archetype archetype to setup a uPortal
Spring Portlet shell, which itself uses maven for dependency management,
build management, deployment, and test generation.

NOTE

You'll want to change the following files after renaming your portlet:

src/main/resources/helloworld.properties (rename file)
src/main/webapp/context/helloworld-portlet.xml (rename file, and change PropertyPlaceHolderConfigurer)
src/main/webapp/WEB-INF/portlet.xml contextConfigLocation element and PropertyPlaceHolderConfigurer

Do a 'grep -ri helloworld' to get all the references to rename in files.

SEE ALSO

Apache Maven
JSR 168 Portlet Specification
Sun JDK 1.5+
Spring Portlet MVC
uPortal 3.2.*
