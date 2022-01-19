<h1 align="center">Ratings</h1>

<br/>


## Project Description

This project is a web application which enables users to comment and rate university courses and professors. The frontend is implemented with JavaScript Vue framework, while the backend server is implemented with Java Spring Boot and MyBatis frameworks. A relational MySQL schema is used for the database of the server.

Click [here](#) for a Chinese version of README file. 项目的中文介绍请点击[这里](#).

For how to launch the project locally, please scroll to the bottom.

<br/>

## Project Preview

### Client Side Preview Screenshots:

![](/readme-pics/client1.png)<br/>

![](/readme-pics/client2.png)<br/>

![](/readme-pics/client3.png)<br/>

![](/readme-pics/client4.png)<br/>

![](/readme-pics/client5.png)<br/>

![](/readme-pics/client6.png)<br/>

![](/readme-pics/client7.png)<br/>

![](/readme-pics/client8.png)<br/>

![](/readme-pics/client9.png)<br/>

### Admin Side Preview Screenshots:

![](/readme-pics/admin1.png)<br/>

![](/readme-pics/admin2.png)<br/>

![](/readme-pics/admin3.png)<br/>

![](/readme-pics/admin4.png)<br/>

![](/readme-pics/admin5.png)<br/>

![](/readme-pics/admin6.png)<br/>

![](/readme-pics/admin7.png)<br/>

<br/>

## Project Features

<br/>

### Client/Users Features:
#### For all clients:
- Show course and professors' introductions in a sliding window (carousal) format
- Show users' evaluations about courses and professors in a sliding window (carousal) format
- Users sign up and log in

#### For logged in users only:
- Show username and welcome message on the header
- Make comments about courses and professors
- Show comments they made about courses and professors in a "sliding card" format

<br/>

### Administrator Features:
- Log in and Log out
- With a web graphical interface, 
    - View all data; 
    - add and delete some data in the database with a graphical web interface


<br/>

## Frameworks and APIs

### **Backend**:
- SpringBoot
- MyBatis (with mybatis generator)

### **Frontend**:
- Vue
    - vue-router
    - axios
    - vuex
    - ElementUI

<br/>

## Development Environment

- Java: 16.0.1 2021-04-20

- MySQL：Ver 8.0.25 for macos11 on x86_64

- node：v12.4.0, npm: 6.9.0

- IDE：IntelliJ IDEA 2021, VSCode

<br/>

## Download and run locally

<br/>

### 1. Clone the project to local

```bash
git clone https://github.com/yutianw00/RateMyCourse.git
```

<br/>

### 2. Change the configuration files for the server

<br/>
 
#### 2.1 Set up database:

Create a new schema, and run the script `admin.sql`

<br/>

#### 2.2 Change database settings in server spring configuration file: 

in `proj-server/src/main/resources/application.properties` file, set the following:
```
spring.datasource.url=jdbc:mysql://localhost:3306/your-schema-name
spring.datasource.username=your-username (e.g. root)
spring.datasource.password=your-password
```

<br/>

### 3. Install the dependencies for frontend

under the `proj-admin` folder, type command 

```bash
npm install
```

Similarly, under the `proj-client` folder, type command

```bash
npm install
```

*if an error occurs during the above step, make sure the node version is the same as shown above. The version info can be check via command `npm --version` and `node --version`.*

<br/>

### 4. Launch the project

#### Launch the server: 

in CLI, cd into `proj-server` folder and run

```bash
./mvnw spring-boot:run
```

#### Launch the client-side frontend:

cd into `proj-client` folder and run

```bash
npm run dev 
```

#### Launch the admin-side frontend:

cd into `proj-admin` folder and run

```bash
npm run dev 
```

<br/>

## Author and Date
Yutian.W, 2022
