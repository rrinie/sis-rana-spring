package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    public String sayHello() {
        return """
           <div style='background: #111; height: 100vh; display: flex; 
                       justify-content: center; align-items: center; overflow: hidden;'>
               
               <h1 class='jiggle' style='
                   font-family: "Comic Sans MS", cursive, sans-serif; 
                   font-size: 80px;
                   background: linear-gradient(to right, #ff0000, #ff7f00, #ffff00, #00ff00, #0000ff, #4b0082, #8b00ff);
                   -webkit-background-clip: text;
                   -webkit-text-fill-color: transparent;
                   filter: drop-shadow(0 0 10px rgba(255,255,255,0.3));
               '>
                   Günaydın abi yaptım
               </h1>

               <style>
                   .jiggle {
                       display: inline-block;
                       animation: jiggle-dance 0.5s infinite alternate;
                   }

                   @keyframes jiggle-dance {
                       0% { transform: scale(1) rotate(-5deg) translateY(0); }
                       25% { transform: scale(1.1) rotate(5deg) translateY(-10px); }
                       50% { transform: scale(1) rotate(-8deg) translateY(5px); }
                       75% { transform: scale(1.1) rotate(8deg) translateY(-5px); }
                       100% { transform: scale(1.2) rotate(0deg) translateY(0); }
                   }
               </style>
           </div>
           """;
    }
}
