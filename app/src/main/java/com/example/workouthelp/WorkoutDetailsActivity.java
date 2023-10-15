package com.example.workouthelp;




import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;


public class WorkoutDetailsActivity extends AppCompatActivity {


    private TextView workoutTypeTitle, workout1, workout2, workout3, workout4, workout5, workout6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);




        workoutTypeTitle = findViewById(R.id.workoutTypeTitle);
        workout1 = findViewById(R.id.workout1);
        workout2 = findViewById(R.id.workout2);
        workout3 = findViewById(R.id.workout3);
        workout4 = findViewById(R.id.workout4);
        workout5 = findViewById(R.id.workout5);
        workout6 = findViewById(R.id.workout6);



        String workoutType = getIntent().getStringExtra("workoutType");
        if (workoutType != null) {
            workoutTypeTitle.setText(workoutType);
            ArrayList<String> selectedWorkouts = generateWorkouts(workoutType);
            displayWorkouts(selectedWorkouts);
        }


    }


    private ArrayList<String> generateWorkouts(String workoutType) {
        ArrayList<String> workouts = new ArrayList<>();
        Random random = new Random();


        switch (workoutType) {
            case "PUSH":
                // Sample workouts for PUSH type
                ArrayList<String> chestWorkouts = new ArrayList<>(Arrays.asList("Push-up", "Bench Press", "Chest Fly", "Incline Dumbell Press", "Flat Dumbell Press", "Smith Machine Incline", "Chest Press Machine", "Incline Barbell Press"));
                ArrayList<String> tricepWorkouts = new ArrayList<>(Arrays.asList("Tricep Dip", "Skull Crushers", "Tricep Extension", "Tricep Pushdowns", "Tricep Pushdowns (unilateral)", "Tricep Cable Overhead", "Cross Body Tricep Extension"));
                ArrayList<String> shoulderWorkouts = new ArrayList<>(Arrays.asList("Dumbell Shoulder Press", "Lateral Raise", "Front Raise", "Military Press", "Cable Lateral Raise", "Machine Shoulder Press", "Arnold Press" ));


                workouts.add(pickAndRemoveRandomExercise(chestWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(chestWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(tricepWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(tricepWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(shoulderWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(shoulderWorkouts, random));
                break;


            case "PULL":
                ArrayList<String> backWorkouts = new ArrayList<>(Arrays.asList("Pull-up", "Bent Over Row", "Lat Pull Down", "Face Pull", "Rear Delt Fly", "Cable Row", "Machine Row","Dumbell Rear Delts"));
                ArrayList<String> bicepWorkouts = new ArrayList<>(Arrays.asList("Barbell Curl", "Hammer Curl", "Concentration Curl", "Dumbell Curl", "Narrow Grip Pullups", "Spider Curls"));


                workouts.add(pickAndRemoveRandomExercise(backWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(backWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(backWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(bicepWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(bicepWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(bicepWorkouts, random));
                break;


            case "LEGS":
                ArrayList<String> legWorkouts = new ArrayList<>(Arrays.asList("Squat", "Lunge", "Deadlift", "Leg Press", "Leg Curl", "Calf Raise", "Smith Machine Squats", "Goblet Squats", "RDL", "Split Squat", "Hack Squat", "Leg Extension", "Leg Curl"));
                workouts.add(pickAndRemoveRandomExercise(legWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(legWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(legWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(legWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(legWorkouts, random));
                workouts.add(pickAndRemoveRandomExercise(legWorkouts, random));
                break;
        }


        return workouts;
    }


    private String pickAndRemoveRandomExercise(ArrayList<String> exercises, Random random) {
        int index = random.nextInt(exercises.size());
        String exercise = exercises.get(index);
        exercises.remove(index);
        return exercise;
    }


    private void displayWorkouts(ArrayList<String> workouts) {
        workout1.setText(workouts.get(0));
        workout2.setText(workouts.get(1));
        workout3.setText(workouts.get(2));
        workout4.setText(workouts.get(3));
        workout5.setText(workouts.get(4));
        workout6.setText(workouts.get(5));
    }
















}



