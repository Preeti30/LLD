# Blinkit LLD - Order Management System

## 📌 Project Setup & Run Guide

### 🛠 Prerequisites
Ensure you have the following installed:
- **Java 17+** (or compatible version)
- **Maven** (for dependency management)
- **Git** (optional, for version control)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code with Java support)

### 🚀 Step-by-Step Setup

#### 1️⃣ Clone the Repository
```sh
 git clone https://github.com/your-repo/blinkit-LLD.git
 cd blinkit-LLD
```

#### 2️⃣ Build the Project
```sh
mvn clean install
```

#### 3️⃣ Run the Application
```sh
mvn exec:java -Dexec.mainClass="org.example.Main"
```

OR, If using an IDE:
- Open the project
- Navigate to `Main.java`
- Click **Run** ▶️

### 🏗 Project Structure
```
blinkit-LLD/
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   │   ├── Main.java
│   │   │   ├── models/
│   │   │   ├── service/
│   │   │   ├── strategy/
│   ├── test/  (Unit tests)
├── pom.xml  (Maven config)
├── README.md  (This file)
```

### 🛠 Common Issues & Fixes
1. **`JAVA_HOME not set`** – Ensure Java is installed and configured.
2. **`mvn command not found`** – Install Maven and add it to the system path.
3. **Port already in use?** – Check if another process is using the port.

### 📌 Next Steps
- Implement new features
- Optimize performance
- Add API endpoints

🔹 **Happy Coding! 🚀**

