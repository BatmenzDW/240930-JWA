# Mini Bash Shell Replica Activity

## Objective
The goal of this project is to create a **mini bash shell replica** that simulates working in a terminal like cmd or bash. The environment should be entirely virtual, with no direct interaction with the actual file system required.

## Requirements
The application should support the following functionalities:
- **Simulated Commands**: Implement the following commands:
  - `ls`
  - `cat`
  - `cd`
  - `mv`
  - `rm` (should act like `rm -rf`)
- **File System Simulation**: The environment should simulate a file system with directories and files.
- **User Directories**: Each user should have a unique directory in the simulated file system.

## Stretch Goals
To enhance the functionality, implement the following features:
- **Virtual Resource Persistence**: Allow the virtual environment to persist resources via the actual file system.
- **Additional Bash Commands**: Implement more bash commands.
- **Command History Recall**: Allow users to recall previously entered commands.
- **Environment Variable Support**: Implement support for environment variables.
- **Scripting Support**: Allow users to write and execute scripts within the virtual environment.

## Instructions
### Define the Methods Needed for this Application:
- Create a method to initialize the virtual file system.
- Create methods to handle each of the simulated commands (`ls`, `cat`, `cd`, `mv`, `rm`).
- Create methods to manage user directories and simulate user interactions.

### Implement Command Logic:
- Implement the logic for each command, ensuring they interact with the virtual file system correctly.
- Ensure that the `rm` command acts like `rm -rf`, recursively removing directories and files.

### Add Stretch Goals (Optional):
- Develop a method to persist the virtual file system using the actual file system.
- Implement additional bash commands to enhance the simulation.
- Implement command history recall to allow users to navigate through previously entered commands.
- Add support for environment variables to simulate a more realistic shell environment.
- Implement scripting support to allow users to write and execute scripts within the virtual environment.

### Testing:
- Test the shell with various scenarios to ensure accuracy and functionality.
- Verify that each command works as expected and interacts correctly with the virtual file system.
- Test the stretch goals to ensure they enhance the functionality without introducing bugs.

## OOP Suggestions for Mini Bash Shell
- **File and Directory Classes**: Create classes for files and directories to encapsulate all related functionality. This simplifies the main shell logic.
- **User Class**: Create a class for users, each with their own directory and command history. This keeps user-specific data organized.
- **Shell Class**: Create a Shell class to manage the overall state of the shell, including command execution and user interactions. This centralizes the shell management and makes it easier to control the flow of the application.
