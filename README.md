
![alt text](https://github.com/shw5258/Smells_Like_Bakin/blob/master/bakery.PNG?raw=true "Logo Title Text 1")

## *recipes of bread* :bread:

This planet of ours has some `mind-blowing` flavours and surprises and we have recipes from all the corners of it. check out some serious inspiration. :smiley:

###basic concept

`Crepes`
-----------
ingredients | directions
------------ | -------------
1 1/2 cup all-purpose flour | Heat waffle maker
1/4 cup sugar | In a bowl mix together the wet ingredients

###progress
- [x] implementing list view 
- [x] makeing tab views for ingred and direct
- [ ] varying view for tablet.and others

###developement cycle
1. Make my changes
  1. Fix bug
  2. Improve formatting
    * Make the headings bigger
2. Push my commits to GitHub
3. Open a pull request
  * Describe my changes
  * Mention all the members of my team
    * Ask for feedback
  
###Reviews
> "I feel a recipe is only a theme, which an intelligent cook can play each time with a variation." -Madam Benoit

> "When baking, follow directions. When cooking, go by your own taste." -Laiko Bahrs

> "We are living in a world today where lemonade is made from artificial flavors and furniture polish is made from real lemons." -Alfred E. Newman

###Core Code
```java
//List Fragment 
RecyclerView rv = (RecyclerView) inflater.inflate(R.id.fragment_list, container,false).findViewById(R.id.listRecyclerView)
rv.setAdapter(listAdapter);
rv.setLayoutManager(layoutManager);

//Main Activity
ListFragment fragment = new ListFragment();
getSupportFragmentManager().beginTransaction().add(R.id.placeHolder, fragment, LIST_FRAGMENT).commit();

```


