# Customer Management Application

## Overview

<p>This is a simple Customer Management Application developed using Spring Boot for the backend, Angular for the frontend, and MySQL for the database. Hibernate is used for ORM (Object Relational Mapping).</p>

## Features

<ul>
  <li><strong>Add a Customer</strong>: Allows adding new customers to the database.</li>
  <li><strong>Update a Customer</strong>: Enables updating existing customer details.</li>
  <li><strong>Get a Customer</strong>: Retrieves details of a specific customer.</li>
  <li><strong>Delete a Customer</strong>: Removes a customer from the database.</li>
  <li><strong>Get All Customers</strong>: Lists all customers stored in the database.</li>
</ul>

## Technologies Used

<ul>
  <li><strong>Backend</strong>: Spring Boot</li>
  <li><strong>Frontend</strong>: Angular</li>
  <li><strong>Database</strong>: MySQL</li>
  <li><strong>ORM</strong>: Hibernate</li>
</ul>

## Installation and Setup

<h3>Prerequisites</h3>

<ul>
  <li>Java 11 or later</li>
  <li>Node.js and npm</li>
  <li>MySQL</li>
  <li>Git</li>
</ul>

<h3>Backend Setup</h3>

<ol>
  <li>
    <strong>Clone the repository</strong>:
    <pre><code>git clone https://github.com/yourusername/customer-management.git
cd customer-management</code></pre>
  </li>
  <li>
    <strong>Configure the database</strong>:
    <ul>
      <li>Create a MySQL database named <code>customer</code>.</li>
      <li>Update the <code>application.properties</code> file in the <code>src/main/resources</code> directory with your database credentials.</li>
      <pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/customer
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update</code></pre>
    </ul>
  </li>
  <li>
    <strong>Build and run the backend</strong>:
    <pre><code>./mvnw spring-boot:run</code></pre>
  </li>
</ol>

<h3>Frontend Setup</h3>

<ol>
  <li>
    <strong>Navigate to the frontend directory</strong>:
    <pre><code>cd frontend</code></pre>
  </li>
  <li>
    <strong>Install dependencies</strong>:
    <pre><code>npm install</code></pre>
  </li>
  <li>
    <strong>Run the frontend application</strong>:
    <pre><code>ng serve</code></pre>
    <p>The frontend should now be running on <code>http://localhost:4200</code>.</p>
  </li>
</ol>

## Usage

<ol>
  <li>
    <strong>Add a Customer</strong>:
    <ul>
      <li>Navigate to the "Add Customer" section and fill in the required details.</li>
      <li>Click "Submit" to add the customer.</li>
    </ul>
  </li>
  <li>
    <strong>Update a Customer</strong>:
    <ul>
      <li>Go to the "Update Customer" section, select the customer you want to update, and modify the details.</li>
      <li>Click "Update" to save the changes.</li>
    </ul>
  </li>
  <li>
    <strong>Get a Customer</strong>:
    <ul>
      <li>Enter the customer ID in the "Get Customer" section to retrieve the details of a specific customer.</li>
    </ul>
  </li>
  <li>
    <strong>Delete a Customer</strong>:
    <ul>
      <li>In the "Delete Customer" section, enter the customer ID and click "Delete" to remove the customer from the database.</li>
    </ul>
  </li>
  <li>
    <strong>Get All Customers</strong>:
    <ul>
      <li>Visit the "All Customers" section to see a list of all customers stored in the database.</li>
    </ul>
  </li>
</ol>



## Contact

<p>For any questions or suggestions, please contact <a href="mailto:your-email@example.com">handapangodageachinthana@gmail.com</a>.</p>
