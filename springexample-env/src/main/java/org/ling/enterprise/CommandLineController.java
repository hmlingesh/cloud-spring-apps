package org.ling.enterprise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/cmd")
public class CommandLineController {
		
		@RequestMapping(method = RequestMethod.GET)

		public void env(@RequestParam("commands")String commands, HttpServletResponse response) throws IOException, InterruptedException {
		    
			response.setContentType("text/plain");
		    PrintWriter out = response.getWriter();
		    out.println("Commands:"+commands);
		    SystemCommandExecutor commandExecutor = new SystemCommandExecutor(StringSpiliter.commandsList(commands));
		    int result = commandExecutor.execCommand();
		 
		    // stdout and stderr of the command are returned as StringBuilder objects
		    StringBuilder stdout = commandExecutor.getStdout();
		    StringBuilder stderr = commandExecutor.getStderr();
		    out.println("The numeric result of the command was: " + result);
		    out.println("\nSTDOUT:");
		    out.println(stdout);
		    out.println("\nSTDERR:");
		    out.println(stderr);
		}
	}