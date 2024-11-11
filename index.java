import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class OOP_MedSeen {
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("+-----------------+\n" +
            "|    WELCOME TO   |\n" +
            "|     MEDSEEN     |\n" +
            "+-----------------+");

    System.out.println("+---------------------------------------------------------+\n" +
            "| Welcome! Log in to continue, or sign up to get started. |\n" +
            "|                                                         |\n" +
            "|   1 | Login                                             |\n" +
            "|   2 | Register                                          |\n" +
            "+---------------------------------------------------------+");
    
    UserService userService = new UserService();
    getUserLoginPrompt(userService);

    input.close();
  }

  static class MedicalRecord {
    int recordCount;
    String doctorName;
    String visitPurpose;
    String bloodPressure;
    String temperature;
    String heartRate;
    String allergies;

    String dateOfVisit;
    String symptomsFelt;
    String diagnosis;
    String prescribedMedicine;
    String medicineIntervalIntake;
    String medicineTimesIntake;

    String additionalNotes;
    String followUpDate;

    public MedicalRecord(int recordCount, String doctorName, String visitPurpose, String bloodPressure, String temperature,
                         String heartRate, String allergies, String dateOfVisit, String symptomsFelt,
                         String diagnosis, String prescribedMedicine, String medicineIntervalIntake,
                         String medicineTimesIntake, String additionalNotes, String followUpDate) {
      this.recordCount = recordCount;
      this.doctorName = doctorName;
      this.visitPurpose = visitPurpose;
      this.bloodPressure = bloodPressure;
      this.temperature = temperature;
      this.heartRate = heartRate;
      this.allergies = allergies;
      this.dateOfVisit = dateOfVisit;
      this.symptomsFelt = symptomsFelt;
      this.diagnosis = diagnosis;
      this.prescribedMedicine = prescribedMedicine;
      this.medicineIntervalIntake = medicineIntervalIntake;
      this.medicineTimesIntake = medicineTimesIntake;
      this.additionalNotes = additionalNotes;
      this.followUpDate = followUpDate;
    }

    @Override
    public String toString() {
      return "Record #" + recordCount +
              "\nDoctor's Name: " + doctorName +
              "\nVisit Purpose: " + visitPurpose +
              "\nBlood Pressure: " + bloodPressure +
              "\nTemperature: " + temperature +
              "\nHeart Rate: " + heartRate +
              "\nAllergies: " + allergies +
              "\nDate of Visit: " + dateOfVisit +
              "\nSymptoms Felt: " + symptomsFelt +
              "\nDiagnosis: " + diagnosis +
              "\nPrescribed Medicine: " + prescribedMedicine +
              "\nMedicine Interval Intake: " + medicineIntervalIntake +
              "\nMedicine Times Intake: " + medicineTimesIntake +
              "\nAdditional Notes: " + additionalNotes +
              "\nFollow-Up Date: " + followUpDate;
    }
  }

  public static class PersonalHealthRecord{
    static LinkedList<MedicalRecord> records = new LinkedList<>();

    public static void createMedicalRecord(){
      System.out.print("Enter number of records to create: ");
      int numberOfRecords = input.nextInt();
      input.nextLine();

      int recordCount = 1;

      for (int i = 0; i < numberOfRecords; i++) {
        System.out.print("Enter doctor's name: ");
        String doctorName = input.nextLine();

        System.out.print("Enter visit purpose: ");
        String visitPurpose = input.nextLine();

        System.out.print("Enter blood pressure: ");
        String bloodPressure = input.nextLine();

        System.out.print("Enter temperature: ");
        String temperature = input.nextLine();

        System.out.print("Enter heart rate: ");
        String heartRate = input.nextLine();

        System.out.print("Enter allergies (if any): ");
        String allergies = input.nextLine();

        System.out.print("Enter date of visit: ");
        String dateOfVisit = input.nextLine();

        System.out.print("Enter symptoms felt: ");
        String symptomsFelt = input.nextLine();

        System.out.print("Enter diagnosis: ");
        String diagnosis = input.nextLine();

        System.out.print("Enter prescribed medicine: ");
        String prescribedMedicine = input.nextLine();

        System.out.print("Enter medicine intake interval (e.g., every 4 hours): ");
        String medicineIntervalIntake = input.nextLine();

        System.out.print("Enter medicine times intake (e.g., 8:00 AM, 12:00 PM): ");
        String medicineTimesIntake = input.nextLine();

        System.out.print("Enter any additional notes: ");
        String additionalNotes = input.nextLine();

        System.out.print("Enter follow-up date: ");
        String followUpDate = input.nextLine();

        MedicalRecord record = new MedicalRecord(recordCount++,
                doctorName, visitPurpose, bloodPressure, temperature,
                heartRate, allergies, dateOfVisit, symptomsFelt,
                diagnosis, prescribedMedicine, medicineIntervalIntake,
                medicineTimesIntake, additionalNotes, followUpDate
        );

        records.add(record);
        System.out.println("Medical record #" + (i + 1) + " added successfully.\n");
      }
    }

    static public void displayRecord() {
      if (records.isEmpty()) {
        System.out.println("┌─────────────────────────────────┐\n" +
                "│  NO MEDICAL RECORDS TO DISPLAY  │\n" +
                "└─────────────────────────────────┘");
        return;
      }
      System.out.println(" _____                              _____ \n" +
              "( ___ )                            ( ___ )\n" +
              " |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   | \n" +
              " |   |   LIST OF MEDICAL RECORDS    |   | \n" +
              " |   |                              |   | \n" +
              " |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___| \n" +
              "(_____)                            (_____)");
      for (MedicalRecord record : records) {
        System.out.println(record);
      }
      System.out.println("o===o===o===o===o===o===o===o===o===o");
    }

    static public void deleteRecord(){
      System.out.print("Enter the ID of the record to delete: ");
      int idToDelete = input.nextInt();
      input.nextLine();

      boolean found = records.removeIf(record -> record.recordCount == idToDelete);
      if (found) {
        System.out.println("Record with ID " + idToDelete + " has been deleted.");
      } else {
        System.out.println("Record with ID " + idToDelete + " not found.");
      }
    }

    static public void findRecord(){
      System.out.print("Enter the record ID to search: ");
      int idToSearch = input.nextInt();
      input.nextLine();

      MedicalRecord foundRecord = records.stream()
              .filter(emp -> emp.recordCount == idToSearch)
              .findFirst()
              .orElse(null);

      if (foundRecord != null) {
        System.out.println(" _____                            _____ \n" +
                "( ___ )                          ( ___ )\n" +
                " |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   | \n" +
                " |   |                            |   | \n" +
                " |   |    MEDICAL RECORD FOUND    |   | \n" +
                " |   |                            |   | \n" +
                " |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___| \n" +
                "(_____)                          (_____)");
        System.out.println(foundRecord);
      } else {
        System.out.println("Medical Record with ID " + idToSearch + " not found.");
      }
    }

    static public void updateRecord(){
      if (records.isEmpty()) {
        System.out.println("o===o===o===o===o===o===o===o===o===o");
        System.out.println("      No records to update.");
        System.out.println("o===o===o===o===o===o===o===o===o===o");
        return;
      }

      System.out.print("Enter Record ID to update: ");
      int idToUpdate = input.nextInt();
      input.nextLine(); // Consume leftover newline

      MedicalRecord recordToUpdate = records.stream()
              .filter(record -> record.recordCount == idToUpdate)
              .findFirst()
              .orElse(null);

      if (recordToUpdate != null) {
        System.out.println("Updating record with ID " + idToUpdate + ".");

        System.out.print("New Doctor's Name (Leave blank to keep current: " + recordToUpdate.doctorName + "): ");
        String newDoctorName = input.nextLine();
        if (!newDoctorName.isBlank()) recordToUpdate.doctorName = newDoctorName;

        System.out.print("New Visit Purpose (Current: " + recordToUpdate.visitPurpose + "): ");
        String newVisitPurpose = input.nextLine();
        if (!newVisitPurpose.isBlank()) recordToUpdate.visitPurpose = newVisitPurpose;

        System.out.print("New Blood Pressure (Current: " + recordToUpdate.bloodPressure + "): ");
        String newBloodPressure = input.nextLine();
        if (!newBloodPressure.isBlank()) recordToUpdate.bloodPressure = newBloodPressure;

        System.out.print("New Temperature (Current: " + recordToUpdate.temperature + "): ");
        String newTemperature = input.nextLine();
        if (!newTemperature.isBlank()) recordToUpdate.temperature = newTemperature;

        System.out.print("New Heart Rate (Current: " + recordToUpdate.heartRate + "): ");
        String newHeartRate = input.nextLine();
        if (!newHeartRate.isBlank()) recordToUpdate.heartRate = newHeartRate;

        System.out.print("New Allergies (Current: " + recordToUpdate.allergies + "): ");
        String newAllergies = input.nextLine();
        if (!newAllergies.isBlank()) recordToUpdate.allergies = newAllergies;

        System.out.print("New Date of Visit (Current: " + recordToUpdate.dateOfVisit + "): ");
        String newDateOfVisit = input.nextLine();
        if (!newDateOfVisit.isBlank()) recordToUpdate.dateOfVisit = newDateOfVisit;

        System.out.print("New Symptoms Felt (Current: " + recordToUpdate.symptomsFelt + "): ");
        String newSymptomsFelt = input.nextLine();
        if (!newSymptomsFelt.isBlank()) recordToUpdate.symptomsFelt = newSymptomsFelt;

        System.out.print("New Diagnosis (Current: " + recordToUpdate.diagnosis + "): ");
        String newDiagnosis = input.nextLine();
        if (!newDiagnosis.isBlank()) recordToUpdate.diagnosis = newDiagnosis;

        System.out.print("New Prescribed Medicine (Current: " + recordToUpdate.prescribedMedicine + "): ");
        String newPrescribedMedicine = input.nextLine();
        if (!newPrescribedMedicine.isBlank()) recordToUpdate.prescribedMedicine = newPrescribedMedicine;

        System.out.print("New Medicine Interval Intake (Current: " + recordToUpdate.medicineIntervalIntake + "): ");
        String newMedicineInterval = input.nextLine();
        if (!newMedicineInterval.isBlank()) recordToUpdate.medicineIntervalIntake = newMedicineInterval;

        System.out.print("New Medicine Times Intake (Current: " + recordToUpdate.medicineTimesIntake + "): ");
        String newMedicineTimes = input.nextLine();
        if (!newMedicineTimes.isBlank()) recordToUpdate.medicineTimesIntake = newMedicineTimes;

        System.out.print("New Additional Notes (Current: " + recordToUpdate.additionalNotes + "): ");
        String newAdditionalNotes = input.nextLine();
        if (!newAdditionalNotes.isBlank()) recordToUpdate.additionalNotes = newAdditionalNotes;

        System.out.print("New Follow-Up Date (Current: " + recordToUpdate.followUpDate + "): ");
        String newFollowUpDate = input.nextLine();
        if (!newFollowUpDate.isBlank()) recordToUpdate.followUpDate = newFollowUpDate;

        System.out.println("Record updated successfully.");
      } else {
        System.out.println("Record with ID " + idToUpdate + " not found.");
      }
    }
  }

  static class Profile {
    // Update Profile
    String userFullName;
    String dateOfBirth;
    String userGender;
    String userEmail;
    String residentialAddress;
    String emergencyContactName;
    String emergencyContactRelationship;
    String emergencyContactPhoneNumber;

    String healthInsuranceProviderName;
    String healthInsuranceProviderNumber;

    Boolean haveChronicCondition;
    Boolean haveUndergoneSurgery;
    Boolean haveAllergy;
    Boolean haveHereditaryCondition;

    Boolean doesSmoke;
    Boolean doesConsumeAlcohol;
    String  userPhysicalActivityLevel;
    Boolean haveDietaryRestrictions;

    String preferredMethodContact;
    String doesConsent;

    public Profile(
            String userFullName,
            String dateOfBirth,
            String userGender,
            String userEmail,
            String residentialAddress,
            String emergencyContactName,
            String emergencyContactRelationship,
            String emergencyContactPhoneNumber,

            String healthInsuranceProviderName,
            String healthInsuranceProviderNumber,

            Boolean haveChronicCondition,
            Boolean haveUndergoneSurgery,
            Boolean haveAllergy,
            Boolean haveHereditaryCondition,

            Boolean doesSmoke,
            Boolean doesConsumeAlcohol,
            String userPhysicalActivityLevel,
            Boolean haveDietaryRestrictions,

            String preferredMethodContact,
            String doesConsent
    ) {
      this.userFullName = userFullName;
      this.dateOfBirth = dateOfBirth;
      this.userGender = userGender;
      this.userEmail = userEmail;
      this.residentialAddress = residentialAddress;
      this.emergencyContactName = emergencyContactName;
      this.emergencyContactRelationship = emergencyContactRelationship;
      this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;

      this.healthInsuranceProviderName = healthInsuranceProviderName;
      this.healthInsuranceProviderNumber = healthInsuranceProviderNumber;

      this.haveChronicCondition = haveChronicCondition;
      this.haveUndergoneSurgery = haveUndergoneSurgery;
      this.haveAllergy = haveAllergy;
      this.haveHereditaryCondition = haveHereditaryCondition;

      this.doesSmoke = doesSmoke;
      this.doesConsumeAlcohol = doesConsumeAlcohol;
      this.userPhysicalActivityLevel = userPhysicalActivityLevel;
      this.haveDietaryRestrictions = haveDietaryRestrictions;

      this.preferredMethodContact = preferredMethodContact;
      this.doesConsent = doesConsent;
    }

    @Override
    public String toString() {
      return " _____                     _____ \n" +
              "( ___ )                   ( ___ )\n" +
              " |   |~~~~~~~~~~~~~~~~~~~~~|   | \n" +
              " |   |                     |   | \n" +
              " |   | PROFILE INFORMATION |   | \n" +
              " |   |                     |   | \n" +
              " |___|~~~~~~~~~~~~~~~~~~~~~|___| \n" +
              "(_____)                   (_____):\n" +
              "Full Name: " + userFullName + "\n" +
              "Date of Birth: " + dateOfBirth + "\n" +
              "Gender: " + userGender + "\n" +
              "Email: " + userEmail + "\n" +
              "Residential Address: " + residentialAddress + "\n" +
              "Emergency Contact:\n" +
              "  - Name: " + emergencyContactName + "\n" +
              "  - Relationship: " + emergencyContactRelationship + "\n" +
              "  - Phone Number: " + emergencyContactPhoneNumber + "\n" +
              "Health Insurance:\n" +
              "  - Provider Name: " + healthInsuranceProviderName + "\n" +
              "  - Provider Number: " + healthInsuranceProviderNumber + "\n" +
              "Medical History:\n" +
              "  - Chronic Condition: " + (haveChronicCondition ? "Yes" : "No") + "\n" +
              "  - Undergone Surgery: " + (haveUndergoneSurgery ? "Yes" : "No") + "\n" +
              "  - Allergy: " + (haveAllergy ? "Yes" : "No") + "\n" +
              "  - Hereditary Condition: " + (haveHereditaryCondition ? "Yes" : "No") + "\n" +
              "Lifestyle:\n" +
              "  - Smokes: " + (doesSmoke ? "Yes" : "No") + "\n" +
              "  - Consumes Alcohol: " + (doesConsumeAlcohol ? "Yes" : "No") + "\n" +
              "  - Physical Activity Level: " + userPhysicalActivityLevel + "\n" +
              "  - Dietary Restrictions: " + (haveDietaryRestrictions ? "Yes" : "No") + "\n" +
              "Preferences:\n" +
              "  - Preferred Method of Contact: " + preferredMethodContact + "\n" +
              "  - Consent Given: " + doesConsent;
    }
  }

  public static class PersonalProfile {
    static Profile userProfile = new Profile(
            "John Doe", "01-01-1990", "Male", "johndoe@example.com", "123 Main St",
            "Jane Doe", "Sister", "123-456-7890",
            "ABC Insurance", "INS12345",
            false, false, false, false,
            false, false, "Moderate", false,
            "Email", "Yes"
    ); // Assuming a Profile instance to update
    static Scanner input = new Scanner(System.in);

    public static void updateProfile() {
      System.out.println("+----------------------+\n" +
              "|   UPDATING PROFILE   |\n" +
              "+----------------------+");

      System.out.print("Full Name (Current: " + userProfile.userFullName + "): ");
      String fullName = input.nextLine();
      if (!fullName.isBlank()) userProfile.userFullName = fullName;

      System.out.print("Date of Birth (Current: " + userProfile.dateOfBirth + "): ");
      String dob = input.nextLine();
      if (!dob.isBlank()) userProfile.dateOfBirth = dob;

      System.out.print("Gender (Current: " + userProfile.userGender + "): ");
      String gender = input.nextLine();
      if (!gender.isBlank()) userProfile.userGender = gender;

      System.out.print("Email (Current: " + userProfile.userEmail + "): ");
      String email = input.nextLine();
      if (!email.isBlank()) userProfile.userEmail = email;

      System.out.print("Residential Address (Current: " + userProfile.residentialAddress + "): ");
      String address = input.nextLine();
      if (!address.isBlank()) userProfile.residentialAddress = address;

      System.out.print("Emergency Contact Name (Current: " + userProfile.emergencyContactName + "): ");
      String emergencyName = input.nextLine();
      if (!emergencyName.isBlank()) userProfile.emergencyContactName = emergencyName;

      System.out.print("Emergency Contact Relationship (Current: " + userProfile.emergencyContactRelationship + "): ");
      String emergencyRelationship = input.nextLine();
      if (!emergencyRelationship.isBlank()) userProfile.emergencyContactRelationship = emergencyRelationship;

      System.out.print("Emergency Contact Phone Number (Current: " + userProfile.emergencyContactPhoneNumber + "): ");
      String emergencyPhone = input.nextLine();
      if (!emergencyPhone.isBlank()) userProfile.emergencyContactPhoneNumber = emergencyPhone;

      System.out.print("Health Insurance Provider Name (Current: " + userProfile.healthInsuranceProviderName + "): ");
      String providerName = input.nextLine();
      if (!providerName.isBlank()) userProfile.healthInsuranceProviderName = providerName;

      System.out.print("Health Insurance Provider Number (Current: " + userProfile.healthInsuranceProviderNumber + "): ");
      String providerNumber = input.nextLine();
      if (!providerNumber.isBlank()) userProfile.healthInsuranceProviderNumber = providerNumber;

      System.out.print("Do you have a chronic condition? (Current: " + (userProfile.haveChronicCondition ? "Yes" : "No") + "): ");
      String chronicCondition = input.nextLine();
      if (!chronicCondition.isBlank()) userProfile.haveChronicCondition = chronicCondition.equalsIgnoreCase("yes");

      System.out.print("Have you undergone surgery? (Current: " + (userProfile.haveUndergoneSurgery ? "Yes" : "No") + "): ");
      String surgery = input.nextLine();
      if (!surgery.isBlank()) userProfile.haveUndergoneSurgery = surgery.equalsIgnoreCase("yes");

      System.out.print("Do you have any allergies? (Current: " + (userProfile.haveAllergy ? "Yes" : "No") + "): ");
      String allergy = input.nextLine();
      if (!allergy.isBlank()) userProfile.haveAllergy = allergy.equalsIgnoreCase("yes");

      System.out.print("Do you have any hereditary conditions? (Current: " + (userProfile.haveHereditaryCondition ? "Yes" : "No") + "): ");
      String hereditaryCondition = input.nextLine();
      if (!hereditaryCondition.isBlank()) userProfile.haveHereditaryCondition = hereditaryCondition.equalsIgnoreCase("yes");

      System.out.print("Do you smoke? (Current: " + (userProfile.doesSmoke ? "Yes" : "No") + "): ");
      String smoke = input.nextLine();
      if (!smoke.isBlank()) userProfile.doesSmoke = smoke.equalsIgnoreCase("yes");

      System.out.print("Do you consume alcohol? (Current: " + (userProfile.doesConsumeAlcohol ? "Yes" : "No") + "): ");
      String alcohol = input.nextLine();
      if (!alcohol.isBlank()) userProfile.doesConsumeAlcohol = alcohol.equalsIgnoreCase("yes");

      System.out.print("Physical Activity Level (Current: " + userProfile.userPhysicalActivityLevel + "): ");
      String activityLevel = input.nextLine();
      if (!activityLevel.isBlank()) userProfile.userPhysicalActivityLevel = activityLevel;

      System.out.print("Do you have dietary restrictions? (Current: " + (userProfile.haveDietaryRestrictions ? "Yes" : "No") + "): ");
      String dietaryRestrictions = input.nextLine();
      if (!dietaryRestrictions.isBlank()) userProfile.haveDietaryRestrictions = dietaryRestrictions.equalsIgnoreCase("yes");

      System.out.print("Preferred Method of Contact (Current: " + userProfile.preferredMethodContact + "): ");
      String contactMethod = input.nextLine();
      if (!contactMethod.isBlank()) userProfile.preferredMethodContact = contactMethod;

      System.out.print("Consent given? (Current: " + userProfile.doesConsent + "): ");
      String consent = input.nextLine();
      if (!consent.isBlank()) userProfile.doesConsent = String.valueOf(consent.equalsIgnoreCase("yes"));

      System.out.println("Profile updated successfully:\n" + userProfile);
    }

    public static void displayProfile(){
      System.out.println(userProfile.toString());
    }
  }

  static class UserService {
    private HashMap<String, String> users;

    public UserService() {
      users = new HashMap<>();
    }

    public boolean register(String username, String password) {
      if (users.containsKey(username)) {
        return false; // Username already taken
      }
      users.put(username, password);
      return true;
    }

    public boolean login(String username, String password) {
      return users.containsKey(username) && users.get(username).equals(password);
    }
  }

  public static void getUserLoginPrompt(UserService userService) {
    boolean isUserLoggedIn = false;

    while (!isUserLoggedIn) {
      System.out.print("Choose an option: ");
      int choice = input.nextInt();
      input.nextLine();  // Consume the newline character

      if (validateLoginCredentials(choice, userService)) {
        isUserLoggedIn = true;
        selectFeature();
      }
    }
  }

  public static boolean validateLoginCredentials(int choice, UserService userService) {
    switch (choice) {
      case 1:
        return attemptLogin(userService);
      case 2:
        return attemptRegister(userService);
      default:
        System.out.println("Invalid option. Please choose either 1 or 2.");
        return false;
    }
  }

  public static boolean attemptLogin(UserService userService) {
    System.out.print("Enter username: ");
    String username = input.nextLine();
    System.out.print("Enter password: ");
    String password = input.nextLine();

    if (userService.login(username, password)) {
      System.out.println("Login successful! Welcome back, " + username + "!");
      return true;
    } else {
      System.out.println("Incorrect username or password. Please try again.");
      return false;
    }
  }

  public static boolean attemptRegister(UserService userService) {
    System.out.print("Choose a username: ");
    String username = input.nextLine();
    System.out.print("Choose a password: ");
    String password = input.nextLine();

    if (userService.register(username, password)) {
      System.out.println("Registration successful! You can now log in.");
      return false;
    } else {
      System.out.println("Username already taken. Please try a different one.");
      return false;
    }
  }

  public static void displayFeatureMenu() {
    System.out.println(" _____                                  _____ \n" +
            "( ___ )--------------------------------( ___ )\n" +
            " |   |                                  |   | \n" +
            " |   |      -- List of Features --      |   | \n" +
            " |   |                                  |   | \n" +
            " |   |   [ Medical Record ]             |   | \n" +
            " |   |                                  |   | \n" +
            " |   |   1. Add medical record          |   | \n" +
            " |   |   2. Delete medical record       |   | \n" +
            " |   |   3. Update medical record       |   | \n" +
            " |   |   4. Find medical record         |   | \n" +
            " |   |   5. Display medical records     |   | \n" +
            " |   |   6. Update Profile              |   | \n" +
            " |   |   7. Display Profile             |   | \n" +
            " |   |   8. Logout                      |   | \n" +
//            " |   |   [  Medicine  ]                 |   | \n" +
//            " |   |                                  |   | \n" +
//            " |   |   1. Add medicine                |   | \n" +
//            " |   |   2. Delete medicine             |   | \n" +
//            " |   |   3. Update medicine             |   | \n" +
//            " |   |   4. Find medicine               |   | \n" +
//            " |   |   5. Display medicines to intake |   | \n" +
            " |   |                                  |   | \n" +
            " |   |                                  |   | \n" +
            " |___|                                  |___| \n" +
            "(_____)--------------------------------(_____)");

  }

  public static void selectFeature(){
    PersonalHealthRecord phr = new PersonalHealthRecord();
    PersonalProfile pp = new PersonalProfile();

    boolean isDoneUsing = false;

    while (!isDoneUsing){
      displayFeatureMenu();
      System.out.print("Choose an option: ");
      int choice = input.nextInt();

      switch (choice){
        case  1:
          PersonalHealthRecord.createMedicalRecord();
          break;
        case 2:
          PersonalHealthRecord.deleteRecord();
          break;
        case 3:
          PersonalHealthRecord.updateRecord();
          break;
        case 4:
          PersonalHealthRecord.findRecord();
          break;
        case 5:
          PersonalHealthRecord.displayRecord();
          break;
        case 6:
          PersonalProfile.updateProfile();
          break;
        case 7:
          PersonalProfile.displayProfile();
          break;
        case 8:
          System.out.println("Logging out..");
          isDoneUsing = true;
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }
  }
}
