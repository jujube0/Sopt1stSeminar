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
