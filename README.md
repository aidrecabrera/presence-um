
<p align="center"><a href="https://vuejs.org" target="_blank" rel="noopener noreferrer"><img width="100" src="https://user-images.githubusercontent.com/61798731/223683827-3df81494-dd05-4186-a9dd-8c08a0d6095f.png" alt="Vue logo"></a></p>


<p align="center">
  <h1 align="center">Presence</h3>
	<h3 align="center">Automating the Attendance Tracking Through Design and Implementation of a Smart Attendance System Using Java Programming Language</h3>
</p>

# Libraries and Framework

- [JavaFX](https://openjfx.io/)
- [SceneBuilder](https://gluonhq.com/products/scene-builder/)
- [JFoenix](https://github.com/sshahine/JFoenix)
- [ZXing](https://github.com/zxing/zxing)


# Introduction
The attendance tracking system is an essential aspect of managing university school operations. Currently, many universities rely on manual attendance tracking systems, which are time-consuming, inefficient, and prone to errors. This inefficiency is due to the time it takes to mark attendance, the potential for human error, and the difficulty of tracking attendance records for a large number of students. In response to this issue, we aim to develop an attendance tracking system for a university school that will automate attendance tracking, eliminate the need for manual record-keeping, and provide a more efficient and reliable way to manage attendance records. Our proposed system will utilize modern technology to improve the efficiency of attendance tracking and provide a more accurate record of student attendance.

Our attendance tracking system will be developed using Java Object-Oriented Programming principles, which will provide a robust and scalable software architecture. This project will utilize various OOP concepts, such as inheritance, polymorphism, and encapsulation. By using OOP, we will ensure that the codebase is modular, flexible, and easy to maintain.

To demonstrate the functionality of our proposed system, consider the following scenario. In a classroom of a university school, the professor will use the system to take attendance. Each student will have a unique QR code or Barcode depending on what then school prefers to use; that will be used to mark their attendance. The professor will scan the QR code/Barcode with a mobile device, and the system will automatically record the student's attendance. The system will also have a user interface to manage student attendance records, add or remove students, and generate attendance reports.

The manual attendance tracking system in universities is inefficient and time-consuming. The proposed attendance tracking system will provide a solution by automating the attendance tracking process, eliminating human error, and providing accurate records of student attendance. The system will be able to generate real-time attendance reports and will provide a user-friendly interface to manage attendance records. The system will also be able to handle a large number of students, and the records can be stored and accessed securely.

In conclusion, our attendance tracking system for a university school will be an efficient, reliable, and easy-to-use solution for managing student attendance records. By leveraging modern technology and Object-Oriented Programming principles, we will ensure that the system is scalable, flexible, and easy to maintain. The system will utilize Machine-readable code technology and provide CRUD (Create, Read, Update, Delete) functionality to manage attendance records.

Based on the project requirements, the primary technology stack will include Java, JavaFX, and JFoenix. Java will be used as the programming language, JavaFX will be used to develop the graphical user interface (GUI), and JFoenix will be used to enhance the look and feel of the application. Some of the key features of the attendance system developed using Java, JavaFX, and JFoenix may include:

- **Professor Authentication.** The system will require users to log in with a unique username and password to access the system. User authentication will help to ensure the privacy and security of attendance records. It has two options: Sign In which allows the professor to login into the Presence Program; and Register, which allows the professor to register into the Presence Program. With regards to the register functionality, it is not a concern since the administrator has to provide and affix the course list to the database instead of the professor itself. With this, it avoids the unnecessary security breach when it comes to the registration feature.

- **Course Dashboard.** The system will allow administrators to view classes, including the course name, course code, and course schedule. Every course is fixed according to the database import. Thus, the professors are unable to add or delete course list since it is a highly sensitive data to handle. Add and delete functionality is certainly a great feature for data flexibility. However, this feature can also have some disadvantages, such as:  increase the risk of human error or manipulation of the attendance data. It can reduce the accountability and transparency of the attendance system. It can create inconsistency or confusion among students and professors.

That is why the Presence developers of the program will define the Java program where the course list and student information is predetermined by the school administrators (Registrar, SAO, etc.). Therefore, there exists on the assumption that the course list and student information is already provided to the professor.

- **Meeting Management.** In each course, the system will allow administrators to add new meetings and edit the student’s attendance information. There will be three options: Absent, Present, and Excused. Presence is a simple program and the feature to provide three options in setting the status of the student in each meeting session is a salient part of the program.

Supposedly, the tentative proposal for the Presence program was to provide a customizable setting where  the program will allow the professor to customize the settings, such as holidays and non-class days, to reflect the unique schedule of each school. However, with the existent feature of creating a new meeting voluntary for teachers, customizability for holidays is unnecessary. Thus, the developers have deprecated the proposed feature.

- **Automated QR Meeting Management.** It is a way of using QR codes that are usually embedded in the Student IDs to facilitate schedule meetings. QR codes are two-dimensional barcodes that can store various types of information, such as URLs, text, contact details, or in this case, Unique Student IDs.

By providing an automated QR Meeting Management, the professor can mark each student automatically by letting them scan their IDs after the meeting is initiated. Each student can check-in by using their QR codes to register attendees for the class meeting, and to check them in when they arrive. This can save time and paper and reduce errors as well as fraud.

Nevertheless, automated QR Meeting Management is an important functionality because it can enhance the efficiency, engagement, and experience of the professor’s class meeting. Hence, it can help them save time and resources, improve communication and interaction, and increase satisfaction and retention of their students.

-  **Attendance Reporting.** The system will generate real-time attendance reports for each student or class, showing the total number of days attended, the percentage of attendance, and any absences or tardies. This is simply implemented through arithmetic calculation.

-  **UI enhancement.** The system will have a user-friendly and aesthetically pleasing user interface using JFoenix to enhance the look and feel of the application. It will follow the Material Design by Google in order to provide a more intuitive user interface and user experience.

# Data Types
It is imperative that in any Java Software Application, the choice of data types is crucial to the design and functionality of the system. In the context of a Presence: Attendance Tracking System, several data types are important for storing and manipulating course, student, and attendance data. These include int, String, Arrays, Array List, Class, Abstract and Interface, and Object.

 - **String.** It is a data type that represents a sequence of characters. It is widely used in software development for storing and
   manipulating textual data. In the context of a Presence: Attendance
   Tracking System, String data type is useful for storing information
   such as student names, course titles, and other descriptive
   information.
   
 - **Array.** It is a data structure that represents a collection of elements of the same type. In the context of a Presence: Attendance
   Tracking System, arrays are useful for storing attendance data in a
   structured and organized way. For example, an array can be used to
   store attendance data for a particular course, with each element in
   the array representing a student and their attendance status.
   
  - **Class.** It is a user-defined blueprint of data and methods. It is a fundamental concept in object-oriented programming and is used to
   create objects in Java. In the context of a Presence: Attendance
   Tracking System, classes are useful for creating objects that
   represent entities such as students, courses, and attendance records.
   These objects can then be manipulated using methods that are defined
   within the class.
   
  - **Interface.** It is a contract of abstract methods and constants. It is a fundamental concept in Java and is used to define a set of
   methods that a class must implement. In the context of a Presence:
   Attendance Tracking System, interfaces are useful for defining a set
   of methods that can be used to manipulate attendance data. For
   example, an interface can be used to define methods for adding,
   deleting, and updating attendance records.
   
 - **Object.** The superclass of all classes in Java. It represents a generic object that can be used to store any type of data. In the
   context of a Presence: Attendance Tracking System, objects are useful
   for storing and manipulating attendance data in a flexible and
   dynamic way. For example, an object can be used to represent a
   student attendance record, with properties such as student name,
   course title, and attendance status.

The choice of data types is critical to the design and functionality of a Presence: Attendance Tracking System. By using String, Array, Class, Interface, and Object data types, developers can create a robust and scalable system for managing and manipulating attendance data. These data types provide a flexible and powerful set of tools for storing and processing attendance data, and are essential for creating a high-quality attendance tracking system.

# File Manipulation
In any data-intensive application, the ability to read and write data from external sources is crucial. And with this, the Presence Attendance Tracking System is no exception. The developers have implemented a system where, similar to a system anchored on a NoSQL Database, it uses CSV as a file format for the container of each record documents. The FileWriter and FileReader classes are important tools for managing and processing CSV data in Java. However, in the development of the program, the developers opted to utilize the related InputStreamReader and OutputStreamWriter classin Java, which is the BufferedFileReader and BufferedFileWriter

The main difference is that FileWriter and FileReader are classes that help to read and write data from and to a file. On the other hand, BufferedFileReader and BufferedFileWriter are classes that help to read and write text from and to another character-based input stream. The main difference between them is that FileWriter and FileReader operate on individual characters, while BufferedFileReader and BufferedFileWriter operate on buffered characters, which is more efficient and faster. Nevertheless, both are still similar.

In a Student Attendance Tracking System that uses CSV (Comma Separated Values) files, the BufferedFileWriter and BufferedReader classes are important components that play a crucial role in improving the efficiency and performance of the system.

The BufferedWriter class provides a convenient way of writing data to a file, with the added benefit of buffering the data before writing it to disk. This buffering mechanism minimizes the number of system calls made to the file, which in turn reduces the overall I/O (Input/Output) overhead and speeds up the file-writing process. Additionally, the BufferedWriter class allows for the use of the newLine() method, which ensures that platform-specific line separators are used, thus improving cross-platform compatibility.

In the program that uses CSV files, the BufferedWriter class can be used to write attendance data to the file in CSV format. This can be done by creating a BufferedWriter object and calling its write() method to write attendance data in the form of CSV records to the file. The use of buffering ensures that the data is written to the file efficiently and in a timely manner, allowing for fast and reliable updates to the attendance records.

In the context of a Student Attendance Tracking System that uses CSV files, the BufferedReader class can be used to read attendance data from the file in CSV format. This can be done by creating a BufferedReader object and calling its readLine() method to read attendance data from the file. The use of buffering ensures that the data is read from the file efficiently and in a timely manner, allowing for fast and reliable retrieval of the attendance records.

The BufferedFileWriter and BufferedReader classes are important components in the program since it uses CSV files. They improve the efficiency and performance of the system by reducing I/O overhead and providing efficient buffering mechanisms for writing and reading data to and from files. By using these classes, the system can reliably and efficiently track student attendance records, providing accurate and up-to-date information to teachers, administrators, and other stakeholders.

## License

[MIT](https://opensource.org/licenses/MIT) Copyright (c) 2023, Aidre Cabrera and Andre John
