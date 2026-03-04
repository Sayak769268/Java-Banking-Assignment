Hyuandai Autoever Assignment

Task


Design a Payment system using oops
1. define a common abstraction for payment
2. implement atleast 2 concrete payment types
3. each payment type must provide its own payment behaviour
4. show runtime polymorphism using a common reference type
5. ensure internal data is properly encapsulated
6. prevent invalid payment values(eg negative amounts)
7. design a system so that new payment types can be added without modifying the existing processing logic

# Activity

# Activity: Build a Fully Responsive Dashboard (HTML + CSS Only)

Your task is to build a **modern web dashboard UI** similar to an admin panel.

Think **Spotify / Notion / GitHub dashboard style**.

No JavaScript allowed.

---

# Requirements

## 1. Layout System

Create a **3-part layout**

```
Sidebar | Main Content | Right Panel
```

On desktop:

```
-----------------------------------------
| Sidebar | Main Dashboard | Activity   |
|         |                | Panel      |
-----------------------------------------
```

On tablet:

```
---------------------------------
| Sidebar | Main Dashboard      |
---------------------------------
| Activity Panel                |
---------------------------------
```

On mobile:

```
Top Navbar
Main Dashboard
Activity Panel
Sidebar becomes bottom navigation
```

You must implement this using **CSS Grid or Flexbox**.

---

# 2. Sidebar

Include:

- Logo
- Navigation items
- Active item highlight
- Hover animations

Example items

```
Dashboard
Analytics
Projects
Messages
Settings
```

Constraints:

- icon + text alignment
- active item indicator
- smooth hover transition

---

# 3. Dashboard Cards

Create **6 cards** in the main section.

Example cards:

```
Revenue
Visitors
Conversion Rate
Active Users
Tasks Completed
Server Load
```

Each card must include:

- title
- number
- small graph placeholder
- percentage change indicator

The cards must **auto-reflow responsively**.

Example:

Desktop

```
3 columns
```

Tablet

```
2 columns
```

Mobile

```
1 column
```

---

# 4. Activity Panel

Right side panel with a **scrollable activity feed**

Example entries:

```
John uploaded a file
Sarah commented on task
Server deployed successfully
New user registered
```

Requirements:

- vertical timeline style
- avatars
- timestamp
- hover highlight

---

# 5. CSS Challenges You Must Use

You must implement at least these techniques:

### CSS Grid

for the dashboard layout

### Flexbox

inside components

### Custom properties

```
--primary
--bg
--card
--text
```

### Dark mode support

Use

```
@media (prefers-color-scheme: dark)
```

---

### Animations

Add subtle animations:

- hover lift on cards
- sidebar icon highlight
- notification pulse

Use

```
transition
transform
keyframes
```

---

---

# 7. Design Constraints

You cannot use:

❌ Bootstrap

❌ Tailwind

❌ JS

❌ external UI libraries

Only:

```
HTML
CSS
Google Fonts
```
