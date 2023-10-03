
<p align="center"><a href="https://github.com/aidrecabrera/presence-um/edit/master/README.md" target="_blank" rel="noopener noreferrer"><img width="100" src="https://user-images.githubusercontent.com/61798731/223683827-3df81494-dd05-4186-a9dd-8c08a0d6095f.png" alt="Vue logo"></a></p>

<p align="center">
  <h1 align="center">Presence</h3>
	<h3 align="center">Design and Implementation of a Java-Based Machine-Readable Code Attendance System</h3>
</p>

![auth](https://user-images.githubusercontent.com/61798731/223685998-d936c303-9d91-450d-81f1-180921d6d306.png)


# Libraries and Framework

- [JavaFX](https://openjfx.io/)
- [SceneBuilder](https://gluonhq.com/products/scene-builder/)
- [JFoenix](https://github.com/sshahine/JFoenix)
- [ZXing](https://github.com/zxing/zxing)

## Prerequisites

- Java 8 or higher
- Apache Maven 3.9.0 or higher
- Logback Classic 1.2.6 or higher
- SLF4J-nop 2.0.0-alpha2 or higher
- Webcam Capture 0.3.12 or higher
- OpenCV 4.6.0-0 or higher
- ZXing Core 3.4.1 or higher
- ZXing JavaSE 3.4.1 or higher
- JFoenix 9.0.10 or higher
- JavaFX 11.0.2 or higher

## Installation

1. Clone the repository
```
git clone https://github.com/aidrecabrera/presence-um.git
```

2. Install the dependencies
```
mvn clean install
```

3. Compile the application
```
mvn compile
```

4. Run the application
```
mvn javafx:run
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
    
**NOTE** : This project requires **Java 19** SDK and above.
**NOTE** : This project requires **Java jdk-8.0.345.1** and above.

## Introduction

The University Attendance Tracking System is a crucial component of efficient university school management. Traditional manual attendance tracking methods are labor-intensive, error-prone, and inefficient, often struggling to manage the attendance records of large student populations. In response to these challenges, we propose the development of an automated attendance tracking system. This system aims to streamline attendance tracking, eliminate manual record-keeping, and provide a dependable method for maintaining accurate attendance records. Leveraging modern technology and Object-Oriented Programming (OOP) principles, our system will offer efficiency and scalability.

## Technology Stack

Our attendance tracking system will be built using Java and JavaFX for the user interface. We will also integrate JFoenix to enhance the application's visual appeal and adhere to the Material Design principles by Google.

## Object-Oriented Programming

Our project will adhere to Object-Oriented Programming principles to ensure a robust and scalable software architecture. This approach will facilitate code modularity, flexibility, and ease of maintenance. Key OOP concepts such as inheritance, polymorphism, and encapsulation will be employed to optimize the system's design.

## System Functionality

### Professor Authentication

- **Sign In**: Professors will log in using unique usernames and passwords, ensuring privacy and security.
- **Register**: Professors will be registered by administrators to prevent security breaches.

### Course Dashboard

- Administrators can view classes with details like course name, course code, and schedule.
- Course lists and student information are predefined by administrators for data consistency and security.

### Meeting Management

- Administrators can add new meetings and update student attendance (Absent, Present, Excused).
- Customizability for holidays is unnecessary as the course list and schedule are predetermined.

### Automated QR Meeting Management

- QR codes on student IDs streamline attendance tracking.
- Professors initiate meetings, and students scan their IDs to register attendance.
- Saves time, reduces paper usage, and minimizes errors and fraud.

### Attendance Reporting

- Generates real-time attendance reports showing days attended, attendance percentage, and absences/tardies through arithmetic calculations.

### UI Enhancement

- Utilizes JFoenix to create an aesthetically pleasing and user-friendly interface.
- Follows Material Design principles for improved user experience.

## Data Types
As part of the Project Requirements, the Data Types will be briefly introduced. In the context of a Presence: Attendance Tracking System, the choice of data types plays a crucial role in designing and implementing the system. This document outlines the essential data types used within the Java software application, emphasizing their significance in handling course, student, and attendance data.

## String

**Type:** `String`

The `String` data type represents a sequence of characters and is extensively used in software development for managing textual data. In the context of the Presence: Attendance Tracking System, the `String` data type proves invaluable for storing information such as student names, course titles, and other descriptive details.

## Array

**Type:** `Array`

An `Array` is a data structure that collects elements of the same type. In the context of the Presence: Attendance Tracking System, arrays offer a structured and organized approach to storing attendance data. For example, an array can efficiently store attendance records for a specific course, where each element corresponds to a student and their attendance status.

## Class

**Type:** `Class`

A `Class` serves as a user-defined blueprint encompassing both data and methods. This fundamental concept in object-oriented programming is employed to create Java objects. In the context of the Presence: Attendance Tracking System, classes are instrumental in creating objects representing entities like students, courses, and attendance records. These objects are subsequently manipulated using methods defined within the class.

## Interface

**Type:** `Interface`

An `Interface` defines a contract comprising abstract methods and constants. This core Java concept specifies a set of methods that must be implemented by a class. In the context of the Presence: Attendance Tracking System, interfaces prove useful in defining a set of methods for manipulating attendance data. For instance, an interface can define methods for adding, deleting, and updating attendance records.

## Object

**Type:** `Object`

The `Object` data type represents the superclass of all classes in Java, allowing storage of generic data. Within the Presence: Attendance Tracking System, objects offer a flexible and dynamic means of storing and manipulating attendance data. For example, an object can represent a student attendance record, featuring properties such as student name, course title, and attendance status.

The choice of data types is critical to the design and functionality of a Presence: Attendance Tracking System. By using String, Array, Class, Interface, and Object data types, developers can create a robust and scalable system for managing and manipulating attendance data. These data types provide a flexible and powerful set of tools for storing and processing attendance data, and are essential for creating a high-quality attendance tracking system.

# File Manipulation
BufferedFileWriter and BufferedReader classes play a pivotal role in the efficiency and effectiveness of a Student Attendance Tracking System that relies on CSV files. These classes optimize data writing and reading processes by minimizing Input/Output (I/O) overhead and providing efficient buffering mechanisms, enhancing the system's performance. BufferedFileWriter simplifies the task of writing attendance data in CSV format by buffering the data and reducing system calls, ensuring fast and reliable updates to attendance records. On the other hand, BufferedReader facilitates the retrieval of attendance data from CSV files with efficient buffering, enabling swift and dependable access to attendance records.

## Dependencies
```
<dependencies>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.6</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-nop</artifactId>
    <version>2.0.0-alpha2</version>
</dependency>
<dependency>
    <groupId>com.github.sarxos</groupId>
    <artifactId>webcam-capture</artifactId>
    <version>0.3.12</version>
</dependency>
<dependency>
    <groupId>org.openpnp</groupId>
    <artifactId>opencv</artifactId>
    <version>4.6.0-0</version>
</dependency>
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>core</artifactId>
    <version>3.4.1</version>
</dependency>
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>javase</artifactId>
    <version>3.4.1</version>
</dependency>
<dependency>
    <groupId>com.jfoenix</groupId>
    <artifactId>jfoenix</artifactId>
    <version>9.0.10</version>
</dependency>

<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>11.0.2</version>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>11.0.2</version>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-graphics</artifactId>
    <version>11</version>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
</dependency>
</dependencies>
```

## License

[MIT](https://opensource.org/licenses/MIT) Copyright (c) 2023, Aidre Cabrera and Andre John
