##It-24048
##Task1 
COMPLPETED

##nth prime number -

package com.example.prime;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        var out = resp.getWriter();
        out.println("<!doctype html><html><body><h1>Find the N-th Prime Number</h1><form action='prime' method='get'><label>Enter n (1-100000): <input type='number' name='n' min='1' max='100000' required></label><button>Find</button></form>");
        String value = req.getParameter("n");
        if (value != null) {
            try {
                int n = Integer.parseInt(value);
                long p = PrimeUtil.nthPrime(n);
                out.printf("<p>The %d-th prime number is <b>%d</b>.</p><a href='save-prime?n=%d'>Save this result to database</a>", n, p, n);
            } catch (RuntimeException e) { out.println("<p style='color:red'>Enter an integer from 1 to 100000.</p>"); }
        }
        out.println("<p><a href='index.html'>Home</a></p></body></html>");
    }
}


<img width="602" height="363" alt="Screenshot 2026-11-01 113540" src="https://github.com/user-attachments/assets/dfee206d-26ce-4839-9791-6984b36f6e1f" />


##TASK-3
##hello world
package com.example.prime;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<!doctype html><html><body><h1>Hello World!</h1><p>Your Apache Tomcat Servlet is running.</p><a href='index.html'>Home</a></body></html>");
    }
}

<img width="520" height="322" alt="Screenshot 2026-11-01 113545" src="https://github.com/user-attachments/assets/810945bf-e650-4940-858f-b417c15d084b" />



##TASK-4
##primerility checker-

package com.example.prime;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/check-prime")
public class PrimalityServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        var out = resp.getWriter();
        out.println("<!doctype html><html><body><h1>Prime Number Checker</h1><form action='check-prime' method='get'><label>Enter an integer: <input type='number' name='number' required></label><button>Check</button></form>");
        String value = req.getParameter("number");
        if (value != null) {
            try {
                long number = Long.parseLong(value);
                out.printf("<h2>%d is %s.</h2>", number, PrimeUtil.isPrime(number) ? "a PRIME number" : "NOT a prime number");
            } catch (NumberFormatException e) { resp.setStatus(400); out.println("<p style='color:red'>Enter a valid 64-bit integer.</p>"); }
        }
        out.println("<p><a href='index.html'>Home</a></p></body></html>");
    }
}

<img width="546" height="333" alt="Screenshot 2026-11-01 113518" src="https://github.com/user-attachments/assets/496fb277-fb0f-4612-bf5b-e4840c52aa54" />

