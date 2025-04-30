package utils;

import java.util.Map;

import Model.Session;

public class PermissionUtils {
    private static Map<String, Boolean[]> permissionMap;

    public static void setPermissionMap(Map<String, Boolean[]> map) {
        permissionMap = map;
    }

    public static Boolean[] getRights(String function) {
        String role = Session.getRole(); 
        String key = function + "_" + role;
        return permissionMap.getOrDefault(key, new Boolean[]{false, false, false, false});
    }

    public static boolean canView(String function) {
        return getRights(function)[0];
    }

    public static boolean canAdd(String function) {
        return getRights(function)[1];
    }

    public static boolean canEdit(String function) {
        return getRights(function)[2];
    }

    public static boolean canDelete(String function) {
        return getRights(function)[3];
    }
}

