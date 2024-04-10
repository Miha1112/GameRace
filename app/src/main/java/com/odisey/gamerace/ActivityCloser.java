package com.odisey.gamerace;
import android.app.Activity;
import java.util.Stack;

public class ActivityCloser {
    private static Stack<Activity> activityStack = new Stack<>();

    // Додайте нову активність до стеку
    public static void addActivity(Activity activity) {
        activityStack.push(activity);
    }

    // Закрийте всі активності в стеку, які не були закриті
    public static void closeAllActivities() {
        while (!activityStack.empty()) {
            Activity activity = activityStack.pop();
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}