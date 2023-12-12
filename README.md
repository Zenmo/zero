<img src="https://zenmo.com/wp-content/uploads/elementor/thumbs/zenmo-logo-website-light-grey-square-o1piz2j6llwl7n0xd84ywkivuyf22xei68ewzwrvmc.png" height="30px"/> ZEnMo Zero
==========

Web-based application to assist modelling and simulating local energy systems.

Components
----------

### [Frontend](frontend)

Graphical user interface.

### [Kleinverbruik](kleinverbruik)

Stedin, Liander and Enexis publish usage data of natural gas and electricity anually.
This is a small webservice which wraps this data so the frontend can request small parts of the data.

### [Ztor](ztor)

This is the base backend built on Ktor framework. Like AnyLogic it leans on the Java ecosystem.

### [Migrations](migrations)

This containers database migrations for PostgreSQL.
This intends to include ALL tables used by the web application and data import tools.

The SQL schema is generated by the Ktor application.
The migrations are created semi-manually by diffing the generated schema with the previous version.

The migrations are applied by Flyway.

### [EP Online](ep-online)

This is a script to import the national dataset of energielabels to a PostgreSQL database.
