
# SyncTalk

A modern real-time messaging platform with private chats, groups, and channels, designed with a scalable architecture.

## Badges

[![Backend](https://img.shields.io/badge/Backend-Spring%20Boot-green)]()
[![Database](https://img.shields.io/badge/Database-PostgreSQL-blue)]()
[![Cache](https://img.shields.io/badge/Cache-Redis-red)]()
[![Realtime](https://img.shields.io/badge/Realtime-WebSockets-orange)]()

[![Web (Planned)](https://img.shields.io/badge/Web-React%20(planned)-blue)]()
[![iOS (Planned)](https://img.shields.io/badge/iOS-Swift%20(planned)-lightgrey)]()
[![Android (Planned)](https://img.shields.io/badge/Android-Kotlin%20(planned)-lightgrey)]()

[![Architecture](https://img.shields.io/badge/Architecture-Monorepo-black)]()
[![Status](https://img.shields.io/badge/Status-In%20Development-yellow)]()
[![License](https://img.shields.io/badge/License-MIT-green)]()
## About the Project

SyncTalk is a real-time messaging system inspired by modern chat applications like WhatsApp and Telegram.

It aims to provide:
- Fast and reliable communication
- Scalable backend architecture
- Multi-platform support (Web, Mobile, Desktop planned)

This project is built as a **full-stack monorepo**, focusing on clean architecture and real-world system design.
## Features (Planned)

- Private one-to-one messaging
- Group chats
- Channels (broadcast system)
- Real-time messaging
- Online / offline presence
- Typing indicators
- User profiles
- Image, audio, and file sharing
- User blocking system
- Message read receipts


## Architecture

The system is divided into three main layers:

- **Backend API** → Spring Boot
- **Web Client (planned)** → React
- **Mobile App (planned)** → Kotlin (Android) / Swift (iOS)

### Core Infrastructure:
- PostgreSQL for persistence
- Redis for real-time state (online users, typing, caching)
- WebSockets for instant communication

---

## Project Structure

```bash id="structure1"
SyncTalk/
├── server/        # Backend API (Spring Boot)
├── web/           # Web client (planned)
├── android/       # Android app (planned)
├── ios/           # iOS app (planned)
├── docs/          # System design & documentation
└── README.md