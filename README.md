# Retrofill - Kotlin
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=19)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

### &#x27A1; [Java version](https://github.com/amoetaz/Retrofill)

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file  

```gradle
dependencies {
	...
	implementation 'com.github.amoetaz:Retrofill-KT:1.0.0'
}
```
## Usage

First if you want to show a normal list -Not a nested- you can do this

``` kotlin
Retrofill(this).showRecyclerViewList( rv_list , R.layout.list_item ) {//Click listener
            startActivity(Intent(this@MainActivity , NestedListActivity::class.java))
        }
```
That is it,and as shown here there are 3 parameters passed to `setupNormalList` method the recyclerView as a view , layout item and the last one is a listener
if you want to add clicks on items list if you don't want so just igonre it like that

``` java
Retrofill(this).showRecyclerViewList( rv_list , R.layout.list_item )  
```

you can customise your list to specifiy list size and span count and more as shown here , note that the values of rest parameters are also a default


``` kotlin
Retrofill(this).showRecyclerViewList( rv_list , R.layout.list_item ,type = LayoutType.LINEAR 
            ,isVertical = true, spanCount = 2, listSize = 6
        ) {//Click listener
            Toast.makeText(this@NestedListActivity , "Fantastic" , Toast.LENGTH_LONG).show()
        }
```
 
 and if you want to show a nested list 

``` kotlin
Retrofill(this).showNestedRecyclerViewList( rv_outer_list , R.layout.outer_list_item ,
            R.id.rv_inner_list , R.layout.inner_list_item  ){
            Toast.makeText(this@NestedListActivity , "Fantastic" , Toast.LENGTH_LONG).show()
        }
```
The parameters as in normal list plus the id of inner recylerview -pass it as id not as a view- and the inner list item

And if you want to specifiy some attributes like in normal list here is the full snippet code


``` kotlin
Retrofill(this).showNestedRecyclerViewList(
            rv_outer_list,
            R.layout.outer_list_item,
            R.id.rv_inner_list,
            R.layout.inner_list_item,
            outerListType = LayoutType.LINEAR,
            innerListType = LayoutType.LINEAR,
            outerListIsVertical = true,
            outerListSpanCount = 2,
            outerListLstSize = 4,
            innerListIsVertical = true,
            innerListSpanCount = 2,
            innerListLstSize = 5
        ) {
            Toast.makeText(this@NestedListActivity, "Fantastic", Toast.LENGTH_LONG).show()
        }
```


## Limitations
Of course there are some limitaions if you will use this lib but in next version I will try work around them
until now these some limitions
* You can`t add click to specific view on list item but you can add click to whole item 
* Custom layout manager is not supported you can only choose form build-in layout manager in android 
* The list items will be identcal as in the xml for example if there is a textview with id tv_text and you set it text in xml with "Hello" so all textviews in other items with id tv_text in run will display with "Hello"

## Notes
1-You can pass layout type to setter LayoutType methods from one of these
* LayoutType.LINEAR
* LayoutType.GRID
* LayoutType.STAGGERED_GRID

2- You must initiate your views in list item in xml and `DON'T` use tools namespace instead use android

3- You should check your xml list item to make sure it is properly suitable with your layout type for example if your layout type is linear sometimes it is better to set the hegiht of parent of list item with wrap content


### Contact - Let's become friends
- [Twitter](https://twitter.com/moetaz_ashraf)
- [Github](https://github.com/amoetaz)
- [Facebook](https://www.facebook.com/amotaz)

<p>
Don't forget to star ⭐ the repo
</p>



## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2020 Moetaz Ashraf

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.