/*
 *   Copyright (c) 2024 Stefano Marano https://github.com/StefanoMarano80017
 *   All rights reserved.

 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.g2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.g2.Exercises.ExerciseRepository;
import com.g2.Goals.GoalRepository;
import com.g2.Goals.GoalService;

@SpringBootApplication(scanBasePackages = {"com.g2.factory", "com.g2.Interfaces", "com.g2.Game", "com.g2.t5", "com.g2.Service", "com.g2.Exercises"})
public class T5Application {

    public static void main(String[] args) {
        SpringApplication.run(T5Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public GoalRepository goalRepository(){
        return new GoalRepository();
    }

    @Bean
    public ExerciseRepository exerciseRepository(){
        return new ExerciseRepository();
    }

    @Bean
    public GoalService goalService(){
        return new GoalService();
    }

}

