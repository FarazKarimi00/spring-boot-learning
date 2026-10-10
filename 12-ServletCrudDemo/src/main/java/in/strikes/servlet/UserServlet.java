package in.strikes.servlet;

import in.strikes.model.User;
import in.strikes.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idParm = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");
        if(idParm == null || email == null || name == null || mobileNo == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"message\" : \"Some fields are missing\"    \n" +
                    "}"
            );
            return;
        }
        Integer id = Integer.parseInt(idParm);
        User user = new User(id, name, email, mobileNo);
        userService.createUser(user);
        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("{\n" +
                "    \"message\" : \"User added successfully\"    \n" +
                "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idParm = request.getParameter("id");
        if(idParm == null) {
            List<User> users = userService.getAllUsers();
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }
        Integer id = Integer.parseInt(idParm);
        User userResp = userService.getUserById(id);
        if(userResp == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            return;
        }
        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(userResp));
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idParm = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");
        response.setContentType("application/json");
        if(idParm == null || name == null || email == null || mobileNo == null) {
            response.setStatus(400);
            response.getWriter().write("""
                {
                    "message" : "Some fields are missing"
                }
                """);
            return;
        }
        Integer id = Integer.parseInt(idParm);
        User existingUser = userService.getUserById(id);
        if(existingUser == null){
            response.setStatus(404);
            response.getWriter().write("""
                {
                    "message" : "User not found"
                }
                """);
            return;
        }
        User updatedUser = new User(id, name, email, mobileNo);
        userService.updateUser(updatedUser);
        response.setStatus(200);
        response.getWriter().write("""
            {
                "message" : "User updated successfully"
            }
            """);
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idParm = request.getParameter("id");
        response.setContentType("application/json");
        if(idParm == null) {
            response.setStatus(400);
            response.getWriter().write("""
                {
                    "message" : "Id is required"
                }
                """);
            return;
        }
        Integer id = Integer.parseInt(idParm);
        User existingUser = userService.getUserById(id);
        if(existingUser == null) {
            response.setStatus(404);
            response.getWriter().write("""
                {
                    "message" : "User not found"
                }
                """);
            return;
        }
        userService.deleteUser(id);
        response.setStatus(200);
        response.getWriter().write("""
            {
                "message" : "User deleted successfully"
            }
            """);
    }

    private String userToJson(User user) {
        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : \"" + user.getName() + "\",\n" +
                "    \"email\" : \"" + user.getEmail() + "\",\n" +
                "    \"mobileNo\" : \"" + user.getMobileNo() + "\"\n" +
                "}";
    }

    private String usersToJson(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0; i < users.size(); i++) {
            stringBuilder.append(userToJson(users.get(i)));
            if(i < users.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

