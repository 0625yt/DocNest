# DocNest 프로젝트

## 소개
**DocNest**는 다양한 문서(DOC, HWP, Excel)를 효과적으로 관리하고 웹 환경에서 사용자에게 제공하기 위해 설계된 **Spring Boot 기반 애플리케이션**입니다.  
이 프로젝트는 문서 편집, 파일 업로드/다운로드, 문서 폴더 및 사용자 관리와 같은 다양한 기능을 제공합니다.  
주요 목적은 사용자 친화적인 UI와 강력한 백엔드 시스템을 통해 문서 관리의 효율성을 극대화하는 것입니다.

---

## 주요 기능
1. **문서 관리**
   - 폴더 내 문서 업로드 기능 제공.
   - 문서 편집과 다양한 작업 기능 제공.

2. **문서 및 파일 관리**
   - 파일 업로드 및 다운로드.
   - 폴더 생성, 삭제 및 계층적 관리.

3. **사용자 관리**
   - 사용자 가입 및 인증.
   - 사용자 권한 설정 및 관리.

4. **보안**
   - Spring Security를 활용한 인증 및 권한 관리.
   - 안전한 문서 및 파일 관리 환경 제공.

---

## 화면 구성 목표
### 1. **문서 관리 화면**
- 사용자는 다양한 문서(DOC, HWP, Excel)를 자유롭게 편집합니다.
- 문서 버전 관리 및 조회 가능.

### 2. **파일 및 폴더 관리 화면**
- 사용자는 폴더를 생성, 삭제, 수정 및 조회할 수 있습니다.
- 파일 업로드 및 다운로드에 대한 UI 제공.

### 3. **사용자 관리 화면**
- 사용자 로그인 및 가입 UI.
- 비밀번호 재설정 기능.

---

## 프로젝트 구조
### 1. **애플리케이션 진입점**
- **`HwpParsingServerApplication.java`**: Spring Boot 애플리케이션의 엔트리 포인트.
- **`ServletInitializer.java`**: 서블릿 컨테이너 배포 설정.

### 2. **주요 디렉토리**
#### **`controller`**
- 클라이언트 요청을 처리하고 API를 제공합니다.
- 주요 클래스:
  - **`AuthController`**: 사용자 인증 및 로그인 처리.
  - **`FileUploadController`**: 파일 업로드 및 다운로드 API 제공.
  - **`FolderController`**: 폴더 생성 및 관리 API.
  - **`JoinAuthController`**: 사용자 가입 및 인증 처리.
  - **`PolarisProxyController`**: 프록시 요청 처리.

#### **`domain`**
- 데이터 모델 클래스가 포함된 디렉토리입니다.
- 주요 클래스:
  - **`DocumnetDomain`**: 문서 데이터 모델.
  - **`UserDomain`**: 사용자 데이터 모델.
  - **`folderinfo`** 하위 디렉토리:
    - **`Folder`**: 폴더 정보를 정의.
    - **`FolderInfoDomain`**: 폴더 상세 정보 정의.

#### **`repository`**
- 데이터베이스와 상호작용하는 JPA 인터페이스가 포함되어 있습니다.
- 주요 클래스:
  - **`JpaLoginRepository`**: 로그인 데이터 저장소.
  - **`JpaUserRepository`**: 사용자 데이터 저장소.
  - **`folderinfo`** 하위 디렉토리:
    - **`FolderRepository`**: 폴더 데이터 저장소.

#### **`security`**
- 보안과 관련된 설정이 포함되어 있습니다.
- 주요 클래스:
  - **`SecurityConfig`**: Spring Security 설정.

#### **`service`**
- 비즈니스 로직을 처리하는 서비스 계층입니다.
- 주요 클래스:
  - **`FileUploadService`**: 파일 업로드와 관련된 로직 처리.
  - **`FolderService`**: 폴더 관련 서비스 로직.

---

## 실행 방법
### 1. **환경 설정**
- Java 11 이상 필요.
- Spring Boot 2.5.4 기반.

### 2. **빌드 및 실행**
1. 프로젝트를 클론합니다:
   ```bash
   git clone https://github.com/0625yt/DocNest.git
   ```
2. 프로젝트 디렉토리로 이동합니다:
   ```bash
   cd DocNest
   ```
3. 프로젝트를 빌드하고 실행합니다:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 기여 방법
이 프로젝트에 기여하려면, 기여 지침을 확인하고 풀 리퀘스트를 제출해주세요.

## 라이선스
이 프로젝트는 [MIT 라이선스](LICENSE)를 따릅니다.
