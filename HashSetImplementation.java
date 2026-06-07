package Week4;
import java.util.HashSet;

public class HashSetImplementation {

    // Internal HashSet managing unique entries
    private final HashSet<String> uniqueSet;

    // Constructor
    public HashSetImplementation() {
        this.uniqueSet = new HashSet<>();
    }

    // 1. ADD: Attempts to insert an element. Returns true if unique, false if duplicate.
    public void addElement(String item) {
        if (item == null || item.trim().isEmpty()) {
            System.out.println("Error: Cannot add null or empty strings.");
            return;
        }
        
        String cleanItem = item.trim();
        
        // HashSet.add() naturally returns false if the item is already present
        boolean isUnique = uniqueSet.add(cleanItem);
        
        if (isUnique) {
            System.out.println("Inserted successfully: \"" + cleanItem + "\"");
        } else {
            System.out.println("Rejected (Duplicate detected): \"" + cleanItem + "\"");
        }
    }

    // 2. CHECK: Verifies presence of an item using O(1) hashing operations
    public void checkElementExists(String item) {
        if (item == null) return;
        String cleanItem = item.trim();
        
        System.out.print("Checking existence of \"" + cleanItem + "\": ");
        if (uniqueSet.contains(cleanItem)) {
            System.out.println("FOUND inside the set.");
        } else {
            System.out.println("NOT FOUND.");
        }
    }

    // 3. REMOVE: Drops the target string item cleanly if present
    public void removeElement(String item) {
        if (item == null) return;
        String cleanItem = item.trim();
        
        System.out.print("Attempting to delete \"" + cleanItem + "\": ");
        if (uniqueSet.remove(cleanItem)) {
            System.out.println("SUCCESSFULLY REMOVED.");
        } else {
            System.out.println("FAILED (Item does not exist).");
        }
    }

    // Utility helper to display current elements
    public void displaySetContents() {
        System.out.println("\n--- Current HashSet Snapshot (Total Unique Items: " + uniqueSet.size() + ") ---");
        if (uniqueSet.isEmpty()) {
            System.out.println("[Set is entirely empty]");
        } else {
            System.out.println(uniqueSet);
        }
        System.out.println("------------------------------------------------------------------\n");
    }

    // ==========================================
    // EXECUTION RUN
    // ==========================================
    public static void main(String[] args) {
        HashSetImplementation manager = new HashSetImplementation();

        // 1. Testing Add and Duplicate Behavior
        System.out.println("=== 1. Inserting Items (With Duplicates) ===");
        manager.addElement("Java");
        manager.addElement("Python");
        manager.addElement("C++");
        
        // Attempting immediate duplicate entry drops
        manager.addElement("Java");   // Duplicate
        manager.addElement("python"); // Lowercase check (Case-sensitive uniqueness)
        manager.displaySetContents();

        // 2. Testing Containment/Search Hooks
        System.out.println("=== 2. Checking Item Presence ===");
        manager.checkElementExists("C++");
        manager.checkElementExists("Ruby"); // Non-existent test
        System.out.println();

        // 3. Testing Deletion Blocks
        System.out.println("=== 3. Executing Removals ===");
        manager.removeElement("Python");
        manager.checkElementExists("Python"); // Verify removal
        manager.displaySetContents();
    }
}