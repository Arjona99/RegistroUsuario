# User register

As an assignment for the Mobile Computer subject, I had to develop an application on Android Studio, wich should have 2 screens. In the first one, an user register with basic data like his name, email, account number and date of birth. Also there is a button to advance to the next screen, but it validates that the data is valid. Then, the second screen displays the information introduced previously, with special calculations like his age and his chinese horoscope animal with an image displayiung this animal.

## Features

### Input validations

<details>
  <summary><b>Name</b></summary><br>
  
  - Should have at least 1 element
  - Doesn't have a max limit
  - Support letter, numbers and special characters _(this is because there are special names like Elon Musk son X AE A-XII )_
  
</details>

<details>
  <summary><b>Email</b></summary><br>
  
  - Uses android default pattern for emails
  
</details>

<details>
  <summary><b>Account number</b></summary><br>
  
  - Should have exactly 9 numbers
  - Support only numbers
  
</details>

<details>
  <summary><b>Date of birth</b></summary><br>
  
  - As it uses `date picker`, the input is always a `string` with the selected date with format **DD/MM/YYYY**
  
</details>

### Detail Screen

- It implements a `ScrollView` for a more user friendly experience
- It implements `ellipsis` when text overflows from `TextViews` in user information values
- The animal of the chinese horoscope is caculated dynamically as its values for the `string` and `drawable` resources

### Translation

The application supports **spanish** and **english** translations

### Extra features

- A `clean` button was implemented to ease the UX
- The disign is **minimalistic**. Personally, I don't like using colors and extravagant font families, I like to keep it _simple and clean_

## Developer

Sebastián Arjona Méndez Albarrán

