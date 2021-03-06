
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AutheticationFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter created");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("in doFilter");
        try{
            HttpServletRequest hr = (HttpServletRequest) request;
            HttpSession hs = hr.getSession();
            boolean flag = (boolean) hs.getAttribute("flag");
            if(flag){
                chain.doFilter(request, response);
                System.out.println("flag");
            }
        }catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
       
    }

    @Override
    public void destroy() {
        System.out.println("filter destroyed");

    }
    
}
