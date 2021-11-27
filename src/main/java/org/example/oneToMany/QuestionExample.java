package org.example.oneToMany;

import org.example.Employee;
import org.example.oneToMany.model.Answer;
import org.example.oneToMany.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Question question = new Question("Ile to jest 4 + 5?");
        Answer answer = new Answer("9", true);
        Answer answer1 = new Answer("5", false);
        Answer answer2 = new Answer("8", false);
        Answer answer3 = new Answer("6", false);

        List<Answer> answers = new ArrayList<>();
        answers.add(answer);
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);

        question.setAnswers(answers);

       // session.save(question);

        Question question2 = new Question("Ile jest 4 - 5?");
        List<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("0", false));
        answers2.add(new Answer("-1", true));
        answers2.add(new Answer("10", false));

        question2.setAnswers(answers2);
       // session.save(question2);

        Query query = session.createQuery("FROM Question");
        List<Question> questions = query.list();

        questions.stream().forEach(
                q -> { System.out.println("\n" + q + ": ");
                question.getAnswers().forEach(
                        a -> System.out.println(" - " + a));
                }
        );

        transaction.commit();
        sessionFactory.close();
        session.close();
    }
}
