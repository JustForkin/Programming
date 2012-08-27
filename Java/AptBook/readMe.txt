AptBook (big java p627; Pr 14.1
-------------------------------
run AppointmentTester.java to execute the program.
AppointmentTester first asks the user whether he wants
to add an apppointment to the schedule, print all
appointments for a given day, (or quit). If the user
wishes to add an appointment, a scanner gathers the appt.
description, start/end times, and date, and validates them.
Then a new appt is created and added to the calendar. If
the user wishes to print appt on a specific date, that date 
is gathered and the method which prints appts is invoked.

Appointment.java allows for Appointments to be created.
Appointments are comparable, based on which falls earliest
chronologically, on the basis of date and then time if the
dates are the same. (Much reformatting/parsing is done in 
order for this to work.)

Schedule.java allows one to construct Schedules, which each 
contain an instance of an array list capable of holding
appointments. Schedule.java contains a method which uses 
select sort to sort the appointments based on which falls
earliest chronologically. isNoConflict is a 
method which determines whether two talks are conflicting or
not by first seeing if they fall on the same date, and if
so, by seeing which talk starts later and then making sure
that the one that starts later also starts after the other 
one ended. addApt uses a binary search on the sorted array
to figure out where to place the new appt being added. It then 
checks that appt's times against the ones before and/or after it
to make sure there is no conflict before the new appt is added.
printDay gathers a day that the user wishes to print appointments
for, convert/parses it, and then checks all appts to see if
any are on that day. If not, it tells user that, but if so, it
prints their info.

Time.java contains static methods which help deal with issues
relating to the intake of time as integers. There's a method 
which puts the colon in the int representing time for 
aesthetic purposes as well as makes sure the time looks like
it sohuld with standard formatting. Another method makes sure
that the int could represent time, since unlike integers, time 
uses clock arithmetic and certain values such as 65 minutes or
25 o'clock do not exist.