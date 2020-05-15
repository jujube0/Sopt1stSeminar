# Sopt1stSeminar
1. constraint layout

bias : 제약조건 중 한 쪽에 더 가깝도록 위젯을 배치하는 것

layout_constraintHorizontal_bias

View.GONE 상태일때?

레이아웃 제약조건 관점에서, GONE 위젯은 여전히 레이아웃의 일부이다 → gone 위젯에 제약조건이 걸린 위젯은, 제약조건은 유효하지만 gone위젯의 margin = 0. 

제악조건의 대상이 gone일 때의 margin을 따로 주는 방법

layout_goneMargin_____

layout_constraintDimensionRatio

; 수평 : 수직 비율로 위젯의 크기를 정하는 것. 

width/ height 중 하나를 0dp or match_constraint로 지정하고 width : height 비율을 주기 

or width, height 둘 다 0dp(match_constraint) 한 후 속성으로 "H(W), 16:9" 입력. H, W는 변경될 사이드

Guideline

; 제약조건을 쉽게 설정하도록 도와주는 헬퍼 클래스

수평/ 수직으로 구분되어 다른 위젯의 배치를 돕고, 

isBlank / isEmpty

; kotli.text

isBlank :  returns true if the char sequence is empty or consists soley of whitespace characters

isEmpty: returns true if char sequence is empty(contains no characters)

isNullOrBlank / isNullOrEmpty

startActivityForResult()

호출한 activity에서 결과 받기

결과 수신: onActivityResult()

requestCode : startActivityForResult()에 전달한 요청코드

resultCode : 두번째 활동이 지정한 결과코드 

RESULT_OK / RESULT_CANCELED

intent : 결과 데이터를 전달하는 intent

finish() finishActivity()

**public void finish ()**

> Call this when your activity is done and should be closed. The ActivityResult is propagated back to whoever launched you via onActivityResult().

**public void finishActivity (int requestCode)**

> Force finish another activity that you had previously started with startActivityForResult(Intent, int)

comparing string in kotlin

== 는 내부적으로 equals를 호출하여 주소값이 아니라 값을 비교하게 됨. (ignoring character case)

주소값을 비교하고 싶다면(reference comparison) === 연산자를 이용하면 됨 

- editable은 equals로 비교할 수 없다. .toString() 해준 후에 비교

SharedPreference

데이터를 파일로 저장한다
getSharedPreferences() can only be called after onCreate() has been called on an Activity.


**
2020-05-06 추가
## SharedPreferences

데이터를 영구저장하는 방법. app에 포함되는 데이터 파일을 디바이스에 (key, value) 형태로 저장한다. 

* [코틀린에서는 변수 생성과 동시에 get/set method 설정 가능하다](https://thdev.tech/androiddev/2017/02/14/Getter-and-Setter/)
  ## Android Application class
1. Activity 간 공동으로 이용 가능한 공유 클래스
2. 안드로이드 앱이 시작할 때 가장 먼저 호출된다.
3. Application class를 상속해야한다.
4. 매서드로도 이용 가능. 

class 를 생성한 후, AndroidManifest.xml의 Application 태그에 name 속성으로 추가해야한다.
android:name=".name"

onCreate() 어플리케이션이 생성될 때 호출된다. 액티비티나 서비스보다 항상 먼저 호출
onTerminate() : 어프리케이션 객체와 모든 컴포넌트가 종료될 때 호출. but 항상 발생하진 않음. 종료 처리할 때만 사용.
onLowMemory() : 시스템이 메모리 리소스가 부족할 때 호출

  ## application context
context> 현재 사용되는 application(or activity)에 대한 포괄적인 정보를 지니고 있는 객체


종류> ApplicationContext와 ActivityContext
Application context는 어플리케이션 자체의 생명주기에 영향을 받는다. 
현재 context와 분리된 어떤 context가 필요하거나, 현재 activity scope을 벗어난 작업을 할 때?
대부분의 GUI(화면, view 등) 작업은 불가능하다. (toast는 가능. 자신만의 윈도우를 형성하기 때문)

activity context는 마찬가지로 액티비티의 생명주기와 함께 작동하므로 onDestroy()와 함께 사용한다. 

`LoginActivity.this` though its referring to your own class which extends Activity class but the base class (Activity) also extends Context class, so it can be used to offer activity context.  
`getApplication()` though its referring to Application object but the Application class extends Context class, so it can be used to offer application context.  
`getApplicationContext()` offers application context.  
`getBaseContext()` offers activity context.  
  
출처: [http://dev.youngkyu.kr/36](http://dev.youngkyu.kr/36) [조영규의 블로그]

activity와 application class들도 모두 context class를 상속 받았다는 것. loginActivity.this는 this에 해당하는 LoginActivity instance가 parameter로 전달되고, 이것은 context를 상속받았기 때문에 context이기에 아무 문제 없이 작동.
