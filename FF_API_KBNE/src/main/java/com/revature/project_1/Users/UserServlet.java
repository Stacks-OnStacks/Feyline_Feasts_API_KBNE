package com.revature.project_1.Users;

import javax.servlet.http.HttpServlet;

public class UserServlet extends HttpServlet {

    private final UserService userService;

    private final ObjectMapper objectMapper;

    private final Logger logger = logManager.getLogger();

    public UserService (UserService userService, ObjectMapper objectMapper) {

        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        String username = req.getParameter("username");
        User authUser = (User) req.getSession().getAttribute("authUser");

        if(usernmae!=null){
            try{
                UserResponse user = userService.findById(username);

                String payload = objectMapper.writeValieAsString(user);
                resp.getWriter().write(payload);
            }
            catch (invalidUserException e) {
                logger.warn("User information entered was not reflective of any user in the database, username provided was: {}", username);
                resp.getWriter().write("user information entered was not in the database.");
                resp.setStTus(404);
            }
        }
        else List<UserResponse> users = userService.readAll();

        String payload = objectMapper.writeValueAsString(users);

        resp.getWriter().write(payload);

    }
    @override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter();
        NewRegistrationRequest user = objectMapper.readValue(req)
    }
}

