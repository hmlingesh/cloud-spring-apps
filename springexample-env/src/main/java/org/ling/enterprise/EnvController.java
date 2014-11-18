package org.ling.enterprise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/env")
public class EnvController {

		@RequestMapping(method = RequestMethod.GET)
		public void env(HttpServletResponse response) throws IOException {
		    response.setContentType("text/plain");
		    PrintWriter out = response.getWriter();
		    out.println("System Environment:");
		    for (Map.Entry<String, String> envvar : System.getenv().entrySet()) {
		        out.println(envvar.getKey() + ": " + envvar.getValue());
		    }
		}
	}