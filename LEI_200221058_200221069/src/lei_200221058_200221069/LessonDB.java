/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Lucas Freixieiro
 */
public class LessonDB {
    private Lesson[] lessons;

    public LessonDB() {
        this.lessons = new Lesson[0];
    }

    public Lesson[] getLessons() {
        return lessons;
    }
    
    public void addLesson(Lesson lesson){
        lessons = ArrayUtils.add(lessons, lesson);
    }
}
