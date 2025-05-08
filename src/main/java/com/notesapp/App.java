package com.notesapp;

public class App {
    public static void main(String[] args) {
        ListManager manager = new ListManager();

        // Create lists using ListManager
        StudyNotes studyNotes = manager.createStudyNotes("Java Programming Notes");
        ToDoList todoList = manager.createToDoList("Project Tasks");
        ToBuyList shoppingList = manager.createToBuyList("Shopping List");

        // StudyNotes operations
        studyNotes.addStudyNote("Object-Oriented Programming Concepts");
        StudyNote note = (StudyNote) studyNotes.itemList.get(0);
        note.addNote(
                "Encapsulation: Bundling data and methods that operate on that data - Hiding implementation details");
        note.addNote("Inheritance: Creating new classes from existing ones");
        note.addNote("Polymorphism: Many forms of the same object");
        studyNotes.updateStudyNote(0, 1, "Object-Oriented Programming Concepts");
        studyNotes.updateStudyNote(0, 3,
                "0:Encapsulation: Bundling data and methods that operate on that data - Hiding implementation details");
        studyNotes.deleteStudyNote(1);

        // ToDoList operations
        todoList.addToDo("Do homework");
        todoList.addToDo("Design responsive UI mockups");
        todoList.updateToDo(0, 2, "Complete math and science homework by Friday");
        todoList.updateToDo(1, 1, "Design responsive UI mockups");
        todoList.toggleToDoStatus(0);
        todoList.deleteToDo(1);

        // ToBuyList operations
        shoppingList.addToBuy("Organic Milk", 1);
        shoppingList.addToBuy("Eggs", 6);
        shoppingList.updateToBuyDetails(0, 1, "Milk");
        shoppingList.updateToBuyQuantity(1, 12);
        shoppingList.toggleToBuyStatus(0);
        shoppingList.deleteToBuy(1);

        // Test ListManager
        manager.updateListName(0, "Advanced Java Programming Notes");
        System.out.println("All Lists:");
        System.out.println(manager);

        NoteList retrievedList = manager.getList(1);
        if (retrievedList != null) {
            System.out.println("Retrieved List:");
            System.out.println(retrievedList);
        }

        boolean removed = manager.removeList(1);
        System.out.println("Removed List 3: " + removed);
        System.out.println("Updated List Count: " + manager.getListCount());

        // Verify sorting
        System.out.println("Lists after deletion:");
        System.out.println(manager);
    }
}
