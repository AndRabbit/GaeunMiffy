# 2차 세미나 과제

![2차 과제](https://user-images.githubusercontent.com/53547556/115981388-51411d80-a5ce-11eb-8f52-4201c3c5933d.gif)


level 1

- Repository 하나의 item 제작(item_repositiory)
- 하나의 iteam에 해당하는 Data Class 제작(RepositoryInfo)
- 뷰를 관리하기 위한 ViewHolder와 Adapter 제작
- Repository 리스트가 들어갈 Fragement를 제작
- RecylerView에 Adapter 연결하고 데이터 넣어주기!

1. **레포지터리 텍스트 말줄임표**

---

ellipsize와 maxLine속성을 사용하여 말줄임표시 넣기!

```kotlin
<TextView
        android:id="@+id/repository_name_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="레파지토리 이름"
        android:textColor="@color/black"
        android:textSize="16sp"
        android:textStyle="bold"
        android:ellipsize="end"
        android:maxLines="1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

**2. More 버튼 추가하여 Fragement activity 띄워주기**

---

Intent를 사용하여 Activity로 화면 전환 해주기

```kotlin
private fun initButtonClickEvent(){
        binding.homeMoreBtn.setOnClickListener{
            Toast.makeText(this, "more버튼 클릭", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,UserInfoActivity::class.java))
        }
    }
```

**3. 이번 과제를 통해 배운 점**

---

용어들이 어렵고 연결 관계가 너무 복잡해서 세미나 들을 때도 힘들었는데,

막상 과제로 차근 차근 해보니 괜찮았다. 

fragment를 사용하는게 낯설었지만 앞으로도 잘 사용해보고 싶다.
