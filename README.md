# TipCalculator
A simple app that helps the user calculate how much to leave as a tip to your server after having a nice meal at a restaurant.

# Version: 2.2
Version 1.0 release date: Feb, 2017

# Project Run Instructions

During the creation of this app, I chose to perform my testing using an android emulator. I was able to get the build to work on my pc with:
- Pixel 5, Android 6.0, API 23
- Pixel 3, Android 9.0, API 28

I have also tried to test on real phones running on android 10, and was able to successfully run the builds on a Pixel 3 and Samsung Note 9.
Emulators running on anything higher than Android 9.0 gives me a black screen error.

# What I Learned
I orignially worked on this app during an android development class in college, and only really worked to build the function that
performed the math calculations for the tip amount. The UI was already built for education purposes during class. However, I wanted to
revisit the idea of a tip calculator again and this time see if I could build it from scratch on my own.

- Setting up and troubleshooting AVDs
- Navigating the xml UI designer
- Different components in android UIs and how to use them
- Tying view components to java variables by Id
- Creating custom colors for light and dark modes

# Future Expansion
- [x] A set of buttons to split a tip between multiple people to display seperately
- [x] Bug testing (especially for no amount entered and no buttons selected when Calculate button pressed)
- [x] Compatibility with Dark Mode - currently inverts text color for text field, button, and spinner
- [x] Maximum amount entered check - cannot enter more than a realistic number
- [x] Keyboard goes away when Calculate button pressed
