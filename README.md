# 4806 Project

[![Build Status](https://travis-ci.org/Apocahub/4806Project.svg?branch=master)](https://travis-ci.org/Apocahub/4806Project)

Heroku: https://sysc4806project.herokuapp.com/

4th Year Project Management System</br>

Profs can enter 4th year project topics, delete ones they no longer offer, or archive them for later use. For a given 4th year project topic, they can enter a description, program restrictions, and the number of students required. Students can look up projects and apply for one that they like. When a project is full, no more students can apply for it. The 4th year project coordinator can search for students without a project and send them a reminder. For the oral presentations, profs and students enter their availability. The 4th year project coordinator can allocate the oral presentations to rooms based on availability. This can be done manually or using a very simple “best effort” algorithm. For the final project, students submit their reports online by a deadline specified by the 4th year project coordinator and enforced by the system.

### Project Members

Conlan LaFreniere | 100971291 <br/>
Andrew Ward | 100898624 <br/>
Samuel Roberts | 100935680 <br/>
Keegan Wills | 100966515

### Project State

Sprint 1 <br/>
Set up with Travis CI <br/>
Deployed on Heroku <br/>
Implemented frontend <br/>
Added Student/Prof/Admin model <br/>
Implemented registration through model <br/>

Sprint 2 <br/>
ORM Diagram/UML Diagram. <br/>
Admin/Student/Prof are able to log in with pre existing accounts. <br/>
Admin/Student/Prof can create a new account if an account does not exist. <br/>
Admin is able to view all students with no projects. <br/>
Student is able to view all projects without maximum number of students. <br/>
Profs can view all of their own projects and create new projects with required attributes. <br/>
Added Css for landing pages. <br/>


Sprint 3 <br/>
Students will need to be able to apply and join projects. <br/>
Students need to be able to submit their project (assuming it's before due date). <br/>
Profs need to be able to archive projects <br/>
Prof and students will need to add availabilty for oral presentations. <br/>
Admin will need to allocate rooms for project presentations based on prof/student availability (automatic OR manual). <br/>
Add unit tests and integration tests <br/>
Make sure UML and ORM is up to date <br/>
Allow admin to notify students without a project and set global project deadline. <br/>
Change program restrictions to be Engineering Programs allowed/disallowed and filter projects accordingly for students. <br/>

Project Demo <br/>
Students, Professors, and Admins can log in using prexisting accounts
A Professor can view projects, create a project, set a description, set the restrictions, and set the max number of students for their projects.
A Professor can view all their current projects, delete projects, or archive them.
A Student can apply for a project, and will be accepted if they qualify. A student can "submit" a report for their final report
and set their availablility for a presentation. (The schedule is currently not working properly but the front end exists) 
Admininstrators can view and "notify" students who don't have projects, and set the due date for all projects.

USERNAME:PASSWORD
StudentTest:p1
StudentTest2:p1
ProfTest:p2
AdminTest:p3
