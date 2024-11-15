public interface Administration {
    void modifyUserDetails(String userId, String newEmail, String newPassword);
    void renameFile(String oldFileName, String newFileName);
}
