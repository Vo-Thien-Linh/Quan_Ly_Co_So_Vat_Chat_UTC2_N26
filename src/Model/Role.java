package Model;

public class Role {
    private int roleId;
    private RoleName roleName; 

    public Role() {
    }

    public Role(int roleId, RoleName roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Getter & Setter
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return switch (roleName) {
        	case ADMIN -> "QUẢN TRỊ VIÊN";
            case LECTURER -> "GIÁO VIÊN";
            case MAINTENANCE -> "BẢO TRÌ";
        };
    }
}

